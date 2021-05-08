package io.pragra.learning.springsecuritydemo.service;

import io.pragra.learning.springsecuritydemo.domain.Student;
import io.pragra.learning.springsecuritydemo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo repo;

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(int id){
        return this.repo.findById(id).orElse(Student.builder().build());
    }

    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAll(){
        return this.repo.findAll();
    }

    public void delete(int id){
        this.repo.deleteById(id);
    }
}
