package com.marc7n.task.service;

import com.marc7n.task.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Page<Student> findAll(Pageable pageable);
    Student findById(int theId);
    void save(Student theStudent);
    void deleteById(int theId);
}
