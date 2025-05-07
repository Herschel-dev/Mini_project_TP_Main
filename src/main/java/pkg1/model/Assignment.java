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

    private String feedback;
    private Integer score;

    // then generate getters/setters:

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}