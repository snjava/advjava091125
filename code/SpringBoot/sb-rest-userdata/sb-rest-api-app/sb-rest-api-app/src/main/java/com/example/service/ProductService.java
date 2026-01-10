package com.example.service;
import com.example.dto.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    List<Product> productList = new ArrayList<>();
    public String addProduct(Product product) {
        productList.add(product);
        return "Product Added Successfully...";
    }
    public List<Product> getAllProduct() {
        return productList;
    }
}
