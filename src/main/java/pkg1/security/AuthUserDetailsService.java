// AuthUserDetailsService.java
package pkg1.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import pkg1.model.Teacher;
import pkg1.repository.TeacherRepository;

import java.util.Collections;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final TeacherRepository teacherRepo;

    public AuthUserDetailsService(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher teacher = teacherRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Teacher not found with email: " + email));

        return new User(teacher.getEmail(), teacher.getPassword(), Collections.emptyList());
    }
}
