package com.marc7n.task.Controller;

import com.marc7n.task.dao.NauczycielRepository;
import com.marc7n.task.entity.Nauczyciel;
import com.marc7n.task.service.NauczycielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NauczycielController {

    private final NauczycielService nauczycielService;

    private final NauczycielRepository nauczycielRepository;

    @Autowired
    public NauczycielController(NauczycielService theNauczycielService, NauczycielRepository nauczycielRepository) {
        nauczycielService = theNauczycielService;
        this.nauczycielRepository = nauczycielRepository;
    }

    @GetMapping("/nauczyciele")
    public Page<Nauczyciel> findAll(Pageable pageable) {
        return nauczycielService.findAll(pageable);
    }

    @PostMapping("/nauczyciele")
    public Nauczyciel addNauczyciel(@RequestBody Nauczyciel theNauczyciel) {
        theNauczyciel.setNauczycielId(0);
        nauczycielService.save(theNauczyciel);
        return theNauczyciel;
    }

    @GetMapping("/nauczyciele/{nauczycielId}")
    public Nauczyciel getNauczyciel(@PathVariable int nauczycielId) {
        Nauczyciel theNauczyciel = nauczycielService.findById(nauczycielId);
        if (theNauczyciel == null) {
            throw new RuntimeException("Nauczyciel id not found -" + nauczycielId);
        }
        return theNauczyciel;
    }

    @GetMapping("/nauczyciele/imie")
    public ResponseEntity<List<Nauczyciel>> getNauczycieleByName(@RequestParam String imie) {
        return new ResponseEntity<>(nauczycielRepository.findByImie(imie), HttpStatus.OK);
    }

    @GetMapping("/nauczyciele/nazwisko")
    public ResponseEntity<List<Nauczyciel>> getNauczycielBySurname(@RequestParam String nazwisko) {
        return new ResponseEntity<>(nauczycielRepository.findByNazwisko(nazwisko), HttpStatus.OK);
    }

    @PutMapping("/nauczyciele")
    public Nauczyciel updateNauczyciel(@RequestBody Nauczyciel theNauczyciel) {
        nauczycielService.save(theNauczyciel);
        return theNauczyciel;
    }

    @DeleteMapping("/nauczyciele{nauczycielId}")
    public String deleteNauczyciel(@PathVariable int nauczycielId) {
        Nauczyciel theNauczyciel = nauczycielService.findById(nauczycielId);
        if (theNauczyciel == null) {
            throw new RuntimeException("Nauczyciel id not found = " + nauczycielId);
        }
        nauczycielService.deleteById(nauczycielId);
        return "Deleted nauczyciel id - " + nauczycielId;
    }
}
