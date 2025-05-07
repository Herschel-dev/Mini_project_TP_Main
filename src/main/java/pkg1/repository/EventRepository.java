// EventRepository.java
package pkg1.repository;

import pkg1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTeacherId(Long teacherId);
}