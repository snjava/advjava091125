package com.example.controller;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/create-product")
    public String saveProduct(@RequestBody Product product) {
        productRepository.save(product); // Insert or Update the records
        return "Product Save Successfully.";
    }
    @GetMapping("/get-all-product")
    public List<Product> getProducts() {
        return productRepository.findAll(); // Select all the records
    }
    @DeleteMapping("/delete-by-id/{pid}")
    public String deleteProduct(@PathVariable(name = "pid") int id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully..";
    }

}
