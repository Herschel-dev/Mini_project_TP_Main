package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pkg1.dto.TeacherDTO;
import pkg1.model.Teacher;
import pkg1.repository.TeacherRepository;

import java.util.Optional; //Handles null values

@Service  //The class is annotated as a Spring service, meaning it will be managed by Spring's Dependency Injection (DI) container.
public class TeacherService {
    private final TeacherRepository teacherRepo;
    private final ModelMapper mapper;

    public TeacherService(TeacherRepository teacherRepo, ModelMapper mapper) {
        this.teacherRepo = teacherRepo;
        this.mapper = mapper;
    }

    public TeacherDTO createTeacher(TeacherDTO dto) {
        Teacher entity = mapper.map(dto, Teacher.class);  // Convert DTO to Entity
        Teacher saved = teacherRepo.save(entity);          // Save the entity to the database
        return mapper.map(saved, TeacherDTO.class);        // Convert the saved entity back to DTO and return it
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found: " + id));  // Throw an error if not found
        return mapper.map(teacher, TeacherDTO.class);  // Convert the Teacher entity to TeacherDTO and return
    }
    

    public TeacherDTO updateTeacher(TeacherDTO dto) {
        Teacher existing = teacherRepo.findById(dto.getId())
            .orElseThrow(() -> new RuntimeException("Teacher not found: " + dto.getId()));

        existing.setName(dto.getName()); // Only update the name

        Teacher updated = teacherRepo.save(existing);
        return mapper.map(updated, TeacherDTO.class);
    }


    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);  // Deletes the teacher with the given id
    }
}
