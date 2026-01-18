package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_info")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    //@SequenceGenerator(name = "emp_seq",  initialValue = 1, allocationSize = 1)
    private int id;
    private String name;
    @Column(name = "empcity")
    private String city;
    @Column(name = "empsalary")
    private Double salary;
    @Column(name = "empexp")
    private int experience;
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
