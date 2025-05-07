// AttendanceRepository.java
package pkg1.repository;

import pkg1.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByTeacherIdAndDate(Long teacherId, LocalDate date);
    List<Attendance> findByCourse(String course);
}
