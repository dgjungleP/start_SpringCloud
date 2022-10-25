package com.jungle.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/echo")
public class EchoApplication02 {

    @GetMapping("/{context}/v1")
    public ResponseEntity<String> echo(@PathVariable("context") String context) {
        return ResponseEntity.ok(context);
    }

    public static void main(String[] args) {
        SpringApplication.run(EchoApplication02.class, args);
    }
}
