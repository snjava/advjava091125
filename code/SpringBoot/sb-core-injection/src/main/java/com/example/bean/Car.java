package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    Engine engine;
    @Autowired
    @Qualifier("marutiObject")
    Company company;
    /*public Car(Engine engine, Company company) { // DI with CI
        this.engine = engine;
        this.company = company;
    }*/
    public void carPower() {
        System.out.println("Printing car Power");
        engine.power();
        company.showCompany();
    }
}
