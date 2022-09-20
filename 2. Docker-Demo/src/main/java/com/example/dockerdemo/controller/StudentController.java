package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.StudentDTO;
import com.example.dockerdemo.model.StudentEntity;
import com.example.dockerdemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<StudentDTO> all() {

        return studentRepository.findAll().stream().
                map(this::map).collect(Collectors.toList());
    }

    private StudentDTO map(StudentEntity entity) {
        return new StudentDTO().setAge(entity.getAge()).setName(entity.getName());
    }

}
