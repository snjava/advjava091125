package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Hello Welcome to Spring Boot REST API";
    }
    @GetMapping("/get-student")
    public Student getStudent() {
        Student student = new Student();
        student.setName("Abc");
        student.setEmail("abc@gmail.com");
        student.setContact(Arrays.asList(6677889l, 77778856l));
        return student;
    }
}
