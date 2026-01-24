package com.learning.controller;

import com.learning.entity.Product;
import com.learning.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/save-products")
    public String saveProduct(@RequestBody List<Product> products) {
        productRepository.saveAll(products);
        return "Products Save Successfully..";
    }
    @GetMapping("/get-products")
    public List<Product> getProductDetails() {
        return productRepository.findAll();
    }

}
