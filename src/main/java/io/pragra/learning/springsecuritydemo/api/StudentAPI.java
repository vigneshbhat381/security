package io.pragra.learning.springsecuritydemo.api;


import io.pragra.learning.springsecuritydemo.domain.Student;
import io.pragra.learning.springsecuritydemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentAPI {
    private final StudentService service;

    @GetMapping("/api/student")
    public List<Student> getAllStudent() {
        return service.getAll();
    }


    @GetMapping("/api/student/{id}")
    public Student getAllStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @PostMapping("/api/student")
    public Student createStudent(@RequestBody  Student student) {
        System.out.println("Runnign Debug");
        return service.createStudent(student);
    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }
}
