package raisetech.student.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/student")
    public String getStudent(@RequestParam String name) {
        Student student = repository.searchByName(name);
        return student.getName() + " " + student.getAge() + "歳";
    }

    // 新しく追加するエンドポイント
    @GetMapping("/students") // 複数の学生を取得するので、エンドポイント名を /students と複数形にするのが一般的です
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping("/student")
    public void registerStudent(@RequestParam String name, @RequestParam int age) { // @RequestParam を追加してURLパラメータから値を取得するようにします
        repository.registerStudent(name, age);
    }

    @PatchMapping("/student")
    public void updateStudentName(@RequestParam String name, @RequestParam int age) { // @RequestParam を追加
        repository.updateStudent(name, age);
    }

    @DeleteMapping("/student")
    public void deleteStudent(@RequestParam String name) { // @RequestParam を追加
        repository.deleteStudent(name);
    }
}