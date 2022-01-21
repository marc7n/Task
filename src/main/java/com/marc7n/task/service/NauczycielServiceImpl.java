package com.marc7n.task.service;

import com.marc7n.task.dao.NauczycielRepository;
import com.marc7n.task.entity.Nauczyciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NauczycielServiceImpl implements NauczycielService {


    private final NauczycielRepository nauczycielRepository;

    @Autowired
    public NauczycielServiceImpl(NauczycielRepository theNauczycielRepository) {
        nauczycielRepository = theNauczycielRepository;
    }

    @Override
    public Page<Nauczyciel> findAll(Pageable pageable) {
        return nauczycielRepository.findAll(pageable);
    }

    @Override
    public Nauczyciel findById(long theId) {
        Optional<Nauczyciel> result = nauczycielRepository.findById(theId);
        Nauczyciel theNauczyciel;
        if (result.isPresent()) {
            theNauczyciel = result.get();
        } else {
            throw new RuntimeException("Did not find nauczyciel id - " + theId);
        }
        return theNauczyciel;
    }

    @Override
    public void save(Nauczyciel theNauczyciel) {
        nauczycielRepository.save(theNauczyciel);
    }

    @Override
    public void deleteById(long theId) {
        nauczycielRepository.deleteById(theId);
    }
}
