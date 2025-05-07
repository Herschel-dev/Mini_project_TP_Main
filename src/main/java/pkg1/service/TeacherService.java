// TeacherService.java
package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pkg1.dto.TeacherDTO;
import pkg1.model.Teacher;
import pkg1.repository.TeacherRepository;

import java.util.Optional;  //Never used for now

@Service
public class TeacherService {
    private final TeacherRepository teacherRepo;
    private final ModelMapper mapper;

    public TeacherService(TeacherRepository teacherRepo, ModelMapper mapper) {
        this.teacherRepo = teacherRepo;
        this.mapper = mapper;
    }

    public TeacherDTO createTeacher(TeacherDTO dto) {
        Teacher entity = mapper.map(dto, Teacher.class);
        Teacher saved = teacherRepo.save(entity);
        return mapper.map(saved, TeacherDTO.class);
    }

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found: " + id));
        return mapper.map(teacher, TeacherDTO.class);
    }

    public TeacherDTO updateTeacher(TeacherDTO dto) {
        Teacher entity = mapper.map(dto, Teacher.class);
        Teacher updated = teacherRepo.save(entity);
        return mapper.map(updated, TeacherDTO.class);
    }

    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

}
