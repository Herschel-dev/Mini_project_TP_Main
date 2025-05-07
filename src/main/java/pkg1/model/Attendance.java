// Attendance.java
package pkg1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance_records")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Boolean present;

    private String course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // getters and setters
}