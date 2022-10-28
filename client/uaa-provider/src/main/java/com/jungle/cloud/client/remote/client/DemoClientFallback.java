package com.jungle.cloud.client.remote.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoClientFallback implements DemoClient {

    @Override
    public ResponseEntity<String> echo(String context) {
        return ResponseEntity.ok("Sorry RPC request failed!");
    }
}
