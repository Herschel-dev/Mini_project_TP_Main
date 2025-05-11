package pkg1.repository;

import pkg1.model.grades;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface gradesRepository extends JpaRepository<grades, Long> {
    List<grades> findByTeacherId(Long teacherId);
    //List<grades> findByStudentId(Long studentId);
}
