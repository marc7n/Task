package com.marc7n.task.dao;


import com.marc7n.task.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByImie(String imie);
    List<Student> findByNazwisko(String nazwisko);
}
