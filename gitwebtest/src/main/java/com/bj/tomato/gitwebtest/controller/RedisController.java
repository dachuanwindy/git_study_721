package com.bj.tomato.gitwebtest.controller;

import com.alibaba.fastjson.JSON;
import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: Redis controller Test
 * @date 2020/1/12 00:16
 */

@RestController
@RequestMapping(value = "redis")
@Slf4j
public class RedisController {

    private final static String TOMATO_KEY = "tomato:key";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate1;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("get/{id}")
    public Object RedisDataTest(@PathVariable String id) {

        Userinfo userinfo = new Userinfo();
        userinfo.setId(1);
        userinfo.setIdcardNo("1234567890");
        userinfo.setUage(123L);
        userinfo.setMobile("13853113268");
        redisTemplate.setStringSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(TOMATO_KEY + id, userinfo, 100, TimeUnit.SECONDS);
        Object key = redisTemplate.opsForValue().get(TOMATO_KEY + id);
        log.info("设置的数据是==={}", JSON.toJSONString(key));
        return key;
    }

    @RequestMapping("redission/{key}")
    public String redissonClientTest(@PathVariable String key) {

        RLock test = redissonClient.getLock(key);
        test.lock(10, TimeUnit.SECONDS);

        log.info("++++++++++++++++++++++");
        log.info("======================");
        return "成功解锁";
    }

    @RequestMapping("trykey/{key}")
    public String test2(@PathVariable String key) throws InterruptedException {

        RLock lock = redissonClient.getLock(key);

        boolean b = lock.tryLock(2, TimeUnit.SECONDS);

        redisTemplate1.opsForValue().setIfAbsent("", "", 100, TimeUnit.SECONDS);
        lock.unlock();
        log.info("==尝试加锁=={}", b);
        return "加锁结果";


    }
}
