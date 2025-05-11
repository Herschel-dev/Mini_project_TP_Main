package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.gradesDTO;
import pkg1.exception.ResourceNotFoundException;
import pkg1.service.gradesService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class gradesController {
    private final gradesService gradesService;

    public gradesController(gradesService gradesService) {
        this.gradesService = gradesService;
    }

    // Create Grade (with default feedback/marksObtained values)
    @PostMapping
    public ResponseEntity<gradesDTO> createGrade(@Valid @RequestBody gradesDTO dto) {
        // Set default values for feedback and marksObtained
        if (dto.getFeedback() == null) {
            dto.setFeedback("Pending");
        }
        if (dto.getMarksObtained() == null) {
            dto.setMarksObtained(0);
        }

        // Automatically assign teacher ID based on token
        gradesDTO created = gradesService.createGrade(dto);
        return ResponseEntity.ok(created);
    }

    // Get all grades from a specific teacher
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<gradesDTO>> getByTeacher(@PathVariable Long teacherId) {
        List<gradesDTO> list = gradesService.getByTeacher(teacherId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Grade", "teacherId", teacherId);
        }
        return ResponseEntity.ok(list);
    }
    
    /*
    // Get all grades for a specific student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<gradesDTO>> getByStudent(@PathVariable Long studentId) {
        List<gradesDTO> list = gradesService.getByStudent(studentId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Grade", "studentId", studentId);
        }
        return ResponseEntity.ok(list);
    }
*/

    // Grade a grade (feedback & marksObtained are part of the request parameters)
    @PutMapping("/{id}/grade")
    public ResponseEntity<gradesDTO> gradeGrade(
            @PathVariable Long id,
            @RequestBody gradesDTO dto) {  // Use @RequestBody to get JSON content
        gradesDTO updated = gradesService.gradeGrade(id, dto.getFeedback(), dto.getMarksObtained());
        if (updated == null) {
            throw new ResourceNotFoundException("Grade", "id", id);
        }
        return ResponseEntity.ok(updated);
    }

}
