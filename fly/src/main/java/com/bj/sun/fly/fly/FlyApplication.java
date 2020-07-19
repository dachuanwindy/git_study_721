package com.bj.sun.fly.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlyApplication.class, args);
    }
}
