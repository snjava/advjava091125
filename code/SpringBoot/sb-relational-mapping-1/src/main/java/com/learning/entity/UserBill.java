package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learning.model.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "user_bill")
@Entity
public class UserBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    private LocalDate billingDate;
    private double billingAmount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus billStatus; // PAID, COD, PAYLATER
    private String paymentMode;
    @JsonManagedReference
    @OneToMany(mappedBy = "billDetails")
    private List<Product> product;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }

    public PaymentStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(PaymentStatus billStatus) {
        this.billStatus = billStatus;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
