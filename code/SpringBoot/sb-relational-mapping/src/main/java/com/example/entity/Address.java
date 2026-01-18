package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "add_info")
public class Address {
    @Id
    private int aid;
    private String city;
    private String pin;
    private String state;
    @JoinColumn(name = "stid")
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER )
    private Student stud;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }
}
