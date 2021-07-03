package com.bj.tomato.mytestservice2.mytestservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class Mytestservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mytestservice2Application.class, args);
    }

}
