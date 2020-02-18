package com.bj.tomato.gitwebtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest(value = "GitwebtestApplication.class")
public class GitwebtestApplicationTests {


    /*
        @Autowired
        private UserInfoService userInfoService;
    */
    @Autowired
    private RedissonClient redissonClient;

    @Test
    void contextLoads() {
        System.out.println("啊啊啊啊啊啊");

        RLock lock = redissonClient.getLock("111");
        boolean locked = lock.isLocked();
        System.out.println(lock);

    }

}
