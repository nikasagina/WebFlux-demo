package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Student;
import com.example.webfluxdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public Mono<Student> getEmployeeById(@PathVariable int id) {
        return studentRepository.getStudentById(id);
    }

    @GetMapping("/all")
    public Flux<Student> getAllEmployees() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/all/firstname")
    public Flux<String> getAllEmployeeFirstnames() {
        return studentRepository.getAllStudents()
                .map(Student::getFirstname);
    }

//    @GetMapping("/all/firstname")
//    public Flux<List<String>> getAllEmployeeFirstnames() {
//        return studentRepository.getAllStudents()
//                .map(Student::getFirstname).buffer();
//    }
}
