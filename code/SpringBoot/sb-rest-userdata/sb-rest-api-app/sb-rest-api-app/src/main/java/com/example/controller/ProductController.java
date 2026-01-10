package com.example.controller;
import com.example.dto.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    //http://localhost:8080/create-product
    @PostMapping("/create-product")
    public String addProduct(@RequestBody Product product) {
        String result = productService.addProduct(product);
        return result;
    }
    //http://localhost:8080/get-all-products
    @GetMapping("/get-all-products")
    public List<Product> getProducts() {
        return productService.getAllProduct();
    }
}
