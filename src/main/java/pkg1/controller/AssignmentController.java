package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.AssignmentDTO;
import pkg1.exception.ResourceNotFoundException;
import pkg1.service.AssignmentService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // Create Assignment (with default feedback/score values)
    @PostMapping
    public ResponseEntity<AssignmentDTO> createAssignment(@Valid @RequestBody AssignmentDTO dto) {
        // Set default values for feedback and score
        if (dto.getFeedback() == null) {
            dto.setFeedback("Test Pending");
        }
        if (dto.getScore() == null) {
            dto.setScore(0);
        }

        AssignmentDTO created = assignmentService.createAssignment(dto);
        return ResponseEntity.ok(created);
    }

    // Get all assignments for a specific teacher
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AssignmentDTO>> getByTeacher(@PathVariable Long teacherId) {
        List<AssignmentDTO> list = assignmentService.getByTeacher(teacherId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Assignment", "teacherId", teacherId);
        }
        return ResponseEntity.ok(list);
    }

    // Grade an assignment (feedback & score are part of the request parameters)
    @PostMapping("/{id}/grade")
    public ResponseEntity<AssignmentDTO> gradeAssignment(
            @PathVariable Long id,
            @RequestParam String feedback,
            @RequestParam int score) {
        AssignmentDTO updated = assignmentService.gradeAssignment(id, feedback, score);
        if (updated == null) {
            throw new ResourceNotFoundException("Assignment", "id", id);
        }
        return ResponseEntity.ok(updated);
    }
}
