package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pkg1.dto.AttendanceDTO;
import pkg1.model.Attendance;
import pkg1.repository.AttendanceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepo;
    private final ModelMapper mapper;

    public AttendanceService(AttendanceRepository attendanceRepo, ModelMapper mapper) {
        this.attendanceRepo = attendanceRepo;
        this.mapper = mapper;
    }

    public AttendanceDTO markAttendance(AttendanceDTO dto) {
        Attendance entity = mapper.map(dto, Attendance.class);
        Attendance saved = attendanceRepo.save(entity);
        return mapper.map(saved, AttendanceDTO.class);
    }

    public List<AttendanceDTO> getBySubject(String subject) {  // Changed from 'course' to 'subject'
        return attendanceRepo.findBySubject(subject)  // Changed from 'findByCourse' to 'findBySubject'
            .stream()
            .map(a -> mapper.map(a, AttendanceDTO.class))
            .collect(Collectors.toList());
    }
}
