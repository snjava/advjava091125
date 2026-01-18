package com.example.controller;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/address-student")
    public String saveStudent(@RequestBody Address address) {
        addressRepository.save(address);
        return "Address Created Successfully";
    }

    @GetMapping("/get-all-address")
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
