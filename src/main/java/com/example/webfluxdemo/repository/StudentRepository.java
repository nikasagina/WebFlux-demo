package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Student;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class StudentRepository {
    private static final Map<Integer, Student> students = Map.of(1, new Student(1, "Nika", "Saginadze"),
                                                          2, new Student(2, "foo", "bar"),
                                                          3, new Student(3, "hello", "world"));

    public Mono<Student> getStudentById(int id) {
        return Mono.just(students.get(id));
    }

    public Flux<Student> getAllStudents() {
        return Flux.fromIterable(students.values());
    }
}
