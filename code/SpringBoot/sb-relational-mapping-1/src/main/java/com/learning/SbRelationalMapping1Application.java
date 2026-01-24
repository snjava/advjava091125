package com.learning;

import com.learning.entity.Product;
import com.learning.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbRelationalMapping1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbRelationalMapping1Application.class, args);
        /*ProductService productService = context.getBean(ProductService.class);

        Product p = productService.getProductById(1);
        System.out.println(p.getPid());
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        System.out.println(p.getQuantity());
        System.out.println(p.getBillDetails().getBillingAmount());*/

	}

}
