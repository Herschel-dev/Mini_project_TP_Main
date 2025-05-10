package pkg1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pkg1.model.Teacher;
import pkg1.repository.TeacherRepository;
import pkg1.dto.TeacherDTO;
import pkg1.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Sign-up endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody TeacherDTO signUpRequest, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed: Missing or invalid fields.");
        }

        String name = signUpRequest.getName();
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();

        // Check if user already exists
        if (teacherRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.status(400).body("Email is already in use");
        }

        Teacher newUser = new Teacher();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));  // Encode the password before saving

        teacherRepository.save(newUser);

        return ResponseEntity.status(201).body("User registered successfully");
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> loginRequest) {
        try {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");

            // Check if the user exists
            Teacher user = teacherRepository.findByEmail(email).orElse(null);
            if (user == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            // Authenticate user with the provided credentials
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
            );

            String token = tokenProvider.generateToken(authentication);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            // Invalid password case
            return ResponseEntity.status(401).body("Invalid credentials");
        } catch (AuthenticationException e) {
            // Catch all other authentication exceptions
            return ResponseEntity.status(401).body("Authentication error");
        }
    }
}
