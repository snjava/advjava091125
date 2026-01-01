package com.example.bean;
public class Company {
    private String name;
    public Company(String name) {
        this.name = name;
    }
    public void showCompany() {
        System.out.println("Car Company Name : " + name);
    }
}
