package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@RestController
public class Application {

    private final Map<String, Map<String, String>> students = new ConcurrentHashMap<>();

    public Application() {
        Map<String, String> kouji = new HashMap<>();
        kouji.put("age", "37");
        kouji.put("major", "Computer Science");
        students.put("Enami Kouji", kouji);

        Map<String, String> hanako = new HashMap<>();
        hanako.put("age", "20");
        hanako.put("major", "Literature");
        students.put("Yamada Hanako", hanako);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @GetMapping("/students")
    public Map<String, Map<String, String>> getAllStudents() {
        return students;
    }

    @GetMapping("/students/{name}")
    public Map<String, String> getStudent(@PathVariable String name) {
        return students.get(name);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Map<String, Map<String, String>> newStudent) {
        for (Map.Entry<String, Map<String, String>> entry : newStudent.entrySet()) {
            students.put(entry.getKey(), entry.getValue());
        }
        return "Student(s) added successfully!";
    }


    @PutMapping("/students/{name}")
    public String updateStudent(@PathVariable String name, @RequestBody Map<String, String> updatedInfo) {
        if (students.containsKey(name)) {
            students.put(name, updatedInfo);
            return "Student " + name + " updated successfully!";







   

        } else {
            return "Student " + name + " not found.";
        }
    }
  }



