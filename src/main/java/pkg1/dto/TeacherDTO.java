// TeacherDTO.java
package pkg1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class TeacherDTO {
    private Long id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
