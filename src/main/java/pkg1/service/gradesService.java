package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pkg1.dto.gradesDTO;
import pkg1.model.Teacher;
import pkg1.model.grades;
import pkg1.repository.TeacherRepository;
import pkg1.repository.gradesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class gradesService {
    private final gradesRepository gradesRepo;
    private final TeacherRepository teacherRepo;
    private final ModelMapper mapper;

    public gradesService(gradesRepository gradesRepo, TeacherRepository teacherRepo, ModelMapper mapper) {
        this.gradesRepo = gradesRepo;
        this.teacherRepo = teacherRepo;
        this.mapper = mapper;
    }

    public gradesDTO createGrade(gradesDTO dto) {
        grades entity = mapper.map(dto, grades.class);

        // Fetch the authenticated teacher based on the token
        String email = SecurityContextHolder.getContext().getAuthentication().getName(); // Get the email from the token
        Teacher teacher = teacherRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Teacher not found with email: " + email));
        entity.setTeacher(teacher);

        grades saved = gradesRepo.save(entity);
        return mapper.map(saved, gradesDTO.class);
    }

    public List<gradesDTO> getByTeacher(Long teacherId) {
        return gradesRepo.findByTeacherId(teacherId)
                .stream()
                .map(g -> mapper.map(g, gradesDTO.class))
                .collect(Collectors.toList());
    }

    public gradesDTO gradeGrade(Long id, String feedback, int marksObtained) {
        grades g = gradesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found: " + id));
        g.setFeedback(feedback);
        g.setMarksObtained(marksObtained);
        grades updated = gradesRepo.save(g);
        return mapper.map(updated, gradesDTO.class);
    }

    /*
    public List<gradesDTO> getByStudent(Long studentId) {
        return gradesRepo.findByStudentId(studentId)
                .stream()
                .map(g -> mapper.map(g, gradesDTO.class))
                .collect(Collectors.toList());
    }
    */
}
