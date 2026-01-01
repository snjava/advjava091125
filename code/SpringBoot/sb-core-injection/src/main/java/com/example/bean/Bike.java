package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike {
    @Autowired
    Engine engine;
    public void bikePower() {
        engine.power();
    }
}
