// AttendanceDTO.java
package pkg1.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AttendanceDTO {
    private Long id;

    @NotNull
    private Long teacherId;

    @NotNull
    private String course;

    @NotNull
    private LocalDate date;

    private Boolean present;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Boolean getPresent() { return present; }
    public void setPresent(Boolean present) { this.present = present; }
}
