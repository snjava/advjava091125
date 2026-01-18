package com.example.controller;

import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/save-student")
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student Created Successfully";
    }
    @GetMapping("/get-all-student")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


}
