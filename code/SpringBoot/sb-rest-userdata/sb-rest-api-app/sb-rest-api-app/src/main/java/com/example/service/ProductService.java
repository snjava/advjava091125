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
    public boolean deleteProduct(int id) {
        Product product = getProductById(id);
        return productList.remove(product);
    }
    public boolean updateProduct(Product product) {
        Product oldProduct = getProductById(product.getId());
        if(oldProduct==null) {
            return false;
        }
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setReviews(product.getReviews());
        return true;
    }
    public boolean updateProductQuantity(int id, int quantity) {
        Product product = getProductById(id);
        if(product == null) {
            return false;
        }
        product.setQuantity(quantity);
        return true;
    }
    public Product getProductById(int id) {
        Product pd = null;
        for(Product product : productList) {
            if(product.getId() == id) {
                pd = product;
                break;
            }
        }
        return pd;
        /*return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .get();*/
    }
}
