// Event.java
package pkg1.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime eventDateTime;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // getters and setters
}