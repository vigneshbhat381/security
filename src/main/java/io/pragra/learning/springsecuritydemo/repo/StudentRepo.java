package io.pragra.learning.springsecuritydemo.repo;

import io.pragra.learning.springsecuritydemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
