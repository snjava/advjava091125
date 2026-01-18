package com.example.mode;

public class EmpPartialData {
    private String name;
    private String city;
    private int exp;

    public EmpPartialData(String name, String city, int exp) {
        this.name = name;
        this.city = city;
        this.exp = exp;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
