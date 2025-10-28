package raisetech.student.management.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import raisetech.student.management.exception.TestException;
import raisetech.student.management.exception.TestException;
@Schema(description = "受講生コース情報")
@Getter
@Setter

public class StudentCourse {

    @Schema(description = "コースID", example = "1234")
    @NotBlank
    private String id;

    @Schema(description = "受講生のID", example = "1234")
    @NotBlank
    private String studentId;

    @Schema(description = "コース名", example = "JAVAコース")
    @NotBlank
    private String courseName;

    @Schema(description = "受講開始日", example = "2025-01-01")
    private LocalDateTime courseStartAt;

    @Schema(description = "受講終了日", example = "2025-04-01")
    private LocalDateTime courseEndAt;
}
