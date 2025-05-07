// Assignment.java
package pkg1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private LocalDateTime deadline;

    private String course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // getters and setters
}