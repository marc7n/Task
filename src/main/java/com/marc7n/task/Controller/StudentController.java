package com.marc7n.task.Controller;

import com.marc7n.task.dao.StudentRepository;
import com.marc7n.task.entity.Student;
import com.marc7n.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService theStudentService, StudentRepository studentRepository) {
        studentService = theStudentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/studenci")
    public Page<Student> findAll(Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @PostMapping("/studenci")
    public Student addStudent(@RequestBody Student theStudent) {
        theStudent.setStudentId(0);
        studentService.save(theStudent);
        return theStudent;
    }

    @GetMapping("studenci/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);
        if (theStudent == null) {
            throw new RuntimeException("Student id not found -" + studentId);
        }
        return theStudent;
    }

    @PutMapping("/studenci")
    public Student updateStudent(@RequestBody Student theStudent) {
        studentService.save(theStudent);
        return theStudent;
    }

    @DeleteMapping("studenci/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);
        if (theStudent == null) {
            throw new RuntimeException("Student id not found " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted student id - " + studentId;
    }

    @GetMapping("/studenci/imie")
    public ResponseEntity<List<Student>> getNauczycieleByName(@RequestParam String imie) {
        return new ResponseEntity<>(studentRepository.findByImie(imie), HttpStatus.OK);
    }
    @GetMapping("/studenci/nazwisko")
    public ResponseEntity<List<Student>> getNauczycieleBySurname(@RequestParam String nazwisko) {
        return new ResponseEntity<>(studentRepository.findByNazwisko(nazwisko), HttpStatus.OK);
    }
}
