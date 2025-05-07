// EventDTO.java
package pkg1.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EventDTO {
    private Long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private LocalDateTime eventTime;

    @NotNull
    private Long teacherId;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
}
