package pkg1.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AssignmentDTO {
    private Long id;

    @NotNull
    private String title;

    private String description;

    @Future
    @NotNull
    private LocalDateTime deadline;

    @NotNull
    private Long teacherId;

    @NotNull
    private String course;

    private String feedback;
    private Integer score;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}
