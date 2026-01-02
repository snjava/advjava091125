package com.example;

import com.example.bean.Car;
import com.example.bean.Company;
import com.example.bean.Engine;
import com.example.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SbCoreInjectionApplication {
    /*@Autowired
    Engine engine;*/
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbCoreInjectionApplication.class, args);
        Student s1 = ctx.getBean(Student.class);
        Student s2 = ctx.getBean(Student.class);
        Student s3 = ctx.getBean(Student.class);
        Student s4 = ctx.getBean(Student.class);
        Student s5 = ctx.getBean(Student.class);
        /*Car car = ctx.getBean(Car.class);
        car.carPower();*/
    }

    @Bean(name = "toyotaObject")
    @Primary
    public Company getCompany1() {
        Company c1 = new Company("Toyota");
        return c1;
    }
    @Bean(name = "marutiObject")
    public Company getCompany2() {
        Company c1 = new Company("Maruti");
        return c1;
    }
}
