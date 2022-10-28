package com.jungle.cloud.client.remote.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "echo-provider", path = "/echo-provider/echo", fallback = DemoClientFallback.class)
public interface DemoClient {


    @GetMapping("/{context}/v1")
    ResponseEntity<String> echo(@PathVariable("context") String context);
}
