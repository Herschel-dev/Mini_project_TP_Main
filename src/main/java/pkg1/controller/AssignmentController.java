// AssignmentController.java
package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.AssignmentDTO;
import pkg1.service.AssignmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<AssignmentDTO> createAssignment(@Valid @RequestBody AssignmentDTO dto) {
        AssignmentDTO created = assignmentService.createAssignment(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AssignmentDTO>> getByTeacher(@PathVariable Long teacherId) {
        List<AssignmentDTO> list = assignmentService.getByTeacher(teacherId);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/{id}/grade")
    public ResponseEntity<AssignmentDTO> gradeAssignment(
            @PathVariable Long id,
            @RequestParam String feedback,
            @RequestParam int score) {
        AssignmentDTO updated = assignmentService.gradeAssignment(id, feedback, score);
        return ResponseEntity.ok(updated);
    }
}
