package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackageClasses = DemoApplication.class)
class DemoApplicationTests {


    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        System.out.println("dddddd");

        redisTemplate.opsForValue().set("123", "111111111111111111");
        Object o = redisTemplate.opsForValue().get("123");
        System.out.println(o);
    }

}
