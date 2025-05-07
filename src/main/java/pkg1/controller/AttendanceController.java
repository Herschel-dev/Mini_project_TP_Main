// AttendanceController.java
package pkg1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg1.dto.AttendanceDTO;
import pkg1.service.AttendanceService;

import javax.validation.Valid;
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

    @GetMapping("/course/{course}")
    public ResponseEntity<List<AttendanceDTO>> getByCourse(@PathVariable String course) {
        List<AttendanceDTO> list = attendanceService.getByCourse(course);
        return ResponseEntity.ok(list);
    }
}
