package raisetech.student.management.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Student {

    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String kanaName;
    private String nickname;
    @NotBlank
    private String email;
    @NotBlank
    private String area;
    private int age;
    private String sex;
    private String remark;
    private boolean isDeleted;

}


