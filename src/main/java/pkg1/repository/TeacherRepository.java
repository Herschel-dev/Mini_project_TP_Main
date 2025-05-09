// TeacherRepository.java
package pkg1.repository;

import pkg1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository; //default operations for database queries
import java.util.Optional; //Handles null values

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
}