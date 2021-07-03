package com.bj.tomato.myservice.myservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MyserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyserviceApplication.class, args);
    }

}
