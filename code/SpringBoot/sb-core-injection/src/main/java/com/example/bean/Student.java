package com.example.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Student {
    public Student() {
        System.out.println("Student Object Created..");
    }
}
