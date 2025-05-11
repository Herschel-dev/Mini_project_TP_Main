package pkg1.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import pkg1.model.Teacher;


public class gradesDTO {
    private Long id;
    
    //Foreign Key
    //@NotNull
    //private Long teacherId;

    @NotNull
    private String gradeType;

    private String description;

    @NotNull
    private String subject;

    //@NotNull
    //private Long studentId;

    private String feedback;
    
    private Integer marksObtained;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    //Connected to specified teacher entity
    //public Long getTeacherId() { return teacherId; }
    //public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public String getGradeType() { return gradeType; }
    public void setGradeType(String gradeType) { this.gradeType = gradeType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    //public Long getStudentId() { return studentId; }
    //public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Integer getMarksObtained() { return marksObtained; }
    public void setMarksObtained(Integer marksObtained) { this.marksObtained = marksObtained; }
}
