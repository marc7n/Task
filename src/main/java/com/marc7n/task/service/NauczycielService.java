package com.marc7n.task.service;

import com.marc7n.task.entity.Nauczyciel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface NauczycielService {

    Page<Nauczyciel> findAll(Pageable pageable);
    Nauczyciel findById(long theId);
    void save(Nauczyciel theNauczyciel);
    void deleteById(long theId);
}
