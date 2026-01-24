package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private double price;
    private int quantity;
    @JsonBackReference
    @JoinColumn(name = "bid")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserBill billDetails;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserBill getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(UserBill billDetails) {
        this.billDetails = billDetails;
    }
}
