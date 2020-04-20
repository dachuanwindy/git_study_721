package com.bj.tomato.gitwebtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * @author sunfch
 * @description: 实现test
 * @date 2020/1/11 23:12
 */
@SpringBootApplication(scanBasePackages = "com.bj.tomato.gitwebtest")
@ImportResource({"classpath*:spring/spring.xml"})
public class GitwebtestApplication {
    public static void main(String[] args) {
        SpringApplication.run(GitwebtestApplication.class, args);
    }

}
