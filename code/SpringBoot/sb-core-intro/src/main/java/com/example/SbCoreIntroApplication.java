package com.example;

import com.example.bean.Student;
import org.demo.Institute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example","org.demo"})
public class SbCoreIntroApplication {
	public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(SbCoreIntroApplication.class, args);
       Institute st = ctx.getBean(Institute.class);
       st.printInstituteName();
	}
    @Bean(name = "inst1")
    @Primary
    public Institute createInstutite1() {
        Institute in = new Institute("RSSoft");
        return in;
    }
    @Bean(name = "inst2")
    public Institute createInstutite2() {
        Institute in = new Institute("Abc Institute");
        return in;
    }

}
