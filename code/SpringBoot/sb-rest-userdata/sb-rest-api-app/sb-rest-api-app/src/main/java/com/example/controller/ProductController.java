package com.example.controller;
import com.example.dto.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // http://localhost:8080/swagger-ui/index.html
    //http://localhost:8080/delete-by-id?pid=2
    @DeleteMapping("/delete-by-id")
    public String deleteById(@RequestParam("pid") int id) {
        boolean result = productService.deleteProduct(id);
        return result
                ? "Product DELETED Successfully"
                : "NO Product found for id : " + id;
    }
    //http://localhost:8080/update-product-details
    @PutMapping("/update-product-details")
    public String updateProduct(@RequestBody Product product) {
        boolean result = productService.updateProduct(product);
        return result
                ? "Product UPDATED Successfully"
                : "NO Product found";
    }
    //http://localhost:8080/update-product-price/1/23242
    @PatchMapping("/update-product-quantity/{pid}/{pqty}")
    public String updateProductQuantity(@PathVariable(name = "pid") int id,
                                        @PathVariable(name = "pqty") int quantity) {
        boolean result = productService.updateProductQuantity(id, quantity);
        return result
                ? "Product Quantity UPDATED Successfully"
                : "NO Product found for ID : " + id;
    }
    @GetMapping("/get-product-by-id/{pid}")
    public ResponseEntity getProductById(@PathVariable(name = "pid") int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Product");
        }
    }
}






