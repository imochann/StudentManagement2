package raisetech.student.management.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class StudentCourse {
    private String id;
    private String studentId;
    @NotBlank
    private String courseName;
    private LocalDateTime courseStartAt;
    private LocalDateTime courseEndAt;
}
