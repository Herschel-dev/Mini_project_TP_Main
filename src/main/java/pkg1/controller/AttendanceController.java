package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.AttendanceDTO;
import pkg1.service.AttendanceService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> markAttendance(@Valid @RequestBody AttendanceDTO dto) {
        AttendanceDTO saved = attendanceService.markAttendance(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/subject/{subject}")  // Changed from '/course/{course}' to '/subject/{subject}'
    public ResponseEntity<List<AttendanceDTO>> getBySubject(@PathVariable String subject) {  // Changed 'course' to 'subject'
        List<AttendanceDTO> list = attendanceService.getBySubject(subject);  // Changed method name to 'getBySubject'
        return ResponseEntity.ok(list);
    }
}
