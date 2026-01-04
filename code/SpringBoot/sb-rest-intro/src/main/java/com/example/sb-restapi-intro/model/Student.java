package com.example.sb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class Student {
    private String name;
    private String email;
    private List<Long> contact;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Long> getContact() {
        return contact;
    }
    public void setContact(List<Long> contact) {
        this.contact = contact;
    }
}
