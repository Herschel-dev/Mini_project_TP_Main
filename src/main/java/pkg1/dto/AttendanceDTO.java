package pkg1.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AttendanceDTO {
    private Long id;

    @NotNull
    private Long teacherId;

    @NotNull
    private String subject;  // Changed from 'course' to 'subject'

    @NotNull
    private LocalDate date;

    private Boolean status;  // Changed from 'present' to 'status'

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
