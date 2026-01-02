package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Hello Welcome to Spring Boot REST API";
    }
    @GetMapping("/hello")
    public String helloMessage() {
        return "Hello Message from REST API";
    }
}
