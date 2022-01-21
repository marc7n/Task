package com.marc7n.task.dao;

import com.marc7n.task.entity.Nauczyciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NauczycielRepository extends JpaRepository<Nauczyciel, Long> {

    List<Nauczyciel> findByImie(String imie);
    List<Nauczyciel> findByNazwisko(String nazwisko);
}
