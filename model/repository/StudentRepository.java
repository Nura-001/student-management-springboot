package com.example.studentweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentweb.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
