// AssignmentService.java
package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pkg1.dto.AssignmentDTO;
import pkg1.model.Assignment;
import pkg1.repository.AssignmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepo;
    private final ModelMapper mapper;

    public AssignmentService(AssignmentRepository assignmentRepo, ModelMapper mapper) {
        this.assignmentRepo = assignmentRepo;
        this.mapper = mapper;
    }

    public AssignmentDTO createAssignment(AssignmentDTO dto) {
        Assignment entity = mapper.map(dto, Assignment.class);
        Assignment saved = assignmentRepo.save(entity);
        return mapper.map(saved, AssignmentDTO.class);
    }

    public List<AssignmentDTO> getByTeacher(Long teacherId) {
        return assignmentRepo.findByTeacherId(teacherId)
            .stream()
            .map(a -> mapper.map(a, AssignmentDTO.class))
            .collect(Collectors.toList());
    }

    public AssignmentDTO gradeAssignment(Long id, String feedback, int score) {
        Assignment a = assignmentRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found: " + id));
        a.setFeedback(feedback);
        a.setScore(score);
        Assignment updated = assignmentRepo.save(a);
        return mapper.map(updated, AssignmentDTO.class);
    }
}
