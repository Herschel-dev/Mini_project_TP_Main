// EventController.java
package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.EventDTO;
import pkg1.service.EventService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO dto) {
        EventDTO created = eventService.createEvent(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<EventDTO>> getByTeacher(@PathVariable Long teacherId) {
        List<EventDTO> list = eventService.getByTeacher(teacherId);
        return ResponseEntity.ok(list);
    }
}
