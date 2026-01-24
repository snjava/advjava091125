package com.learning.controller;

import com.learning.entity.UserBill;
import com.learning.respository.UserBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserBillController {
    @Autowired
    private UserBillRepository userBillRepository;
    @PostMapping("/save-bill")
    public String save(UserBill userBill) {
        userBillRepository.save(userBill);
        return "Bill Created Successfully";
    }
    @GetMapping("/get-bill")
    public List<UserBill> getBillDetails() {
        return userBillRepository.findAll();
    }
}
