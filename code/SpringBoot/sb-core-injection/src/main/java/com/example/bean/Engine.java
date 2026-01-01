package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    //Car car;

    /*@Autowired
    public void setCar(Car car) { // DI with SI
        this.car = car;
    }*/
    public void power() {
        System.out.println("Power of the Engine");
    }
}
