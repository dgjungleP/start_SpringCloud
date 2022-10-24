package com.jungle.cloud.client;

import com.jungle.cloud.client.remote.client.DemoClient;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/uaa")
@EnableFeignClients(basePackages = "com.jungle.cloud.client.remote.client")
public class UAAApplication {

    @Resource
    DemoClient demoClient;

    @GetMapping("/simple/echo/{context}")
    ResponseEntity<String> simpleEcho(@PathVariable("context") String context) {
        return demoClient.echo(context);
    }


    public static void main(String[] args) {
        SpringApplication.run(UAAApplication.class, args);
    }
}
