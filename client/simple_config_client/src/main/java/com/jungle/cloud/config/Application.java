package com.jungle.cloud.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Value("${user.name}")
    private String name;

    @GetMapping("/")
    public String home() {
        return "Hello World " + name;
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
            System.out.println("Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
