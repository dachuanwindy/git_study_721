package com.bj.tomato.gitwebtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class RedisControllerTest {

    @Autowired
    private RedissonClient redissonClient;
    final String key = "LOCK:USER_ID";

    @Test
    public void stringStoreTest() {


        RLock lock = redissonClient.getLock(key);

        RKeys keys = redissonClient.getKeys();
        System.out.println(keys);


        RBucket<Object> sunfengchuan = redissonClient.getBucket(key);
        sunfengchuan.set("今天学习redis");
    }

    /**
     * @description: 实现string 存储于get
     * @author sunfch
     * @date 2020/4/19 16:57
     */
    @Test
    public void stringGetKey() {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        Object o = bucket.get();
        log.info(o.toString());
    }


    // MAP 方式的存储
    final String MapKey = "MAP:STORE:KEY";

    @Test
    public void MapStoreTest() {
        redissonClient.getMap(MapKey).put(MapKey + 1, "测试key+1");
        redissonClient.getMap(MapKey).put(MapKey + 2, "测试key+3");
        redissonClient.getMap(MapKey).put(MapKey + 3, "测试key+2");
    }

    // 获取MAP
    @Test
    public void MapKeyGet() {

        RMap<Object, Object> map = redissonClient.getMap(MapKey);
        Object o = map.get(MapKey + 1);
    }


    final String setKey = "SET:KEY:";

    @Test
    public void SetStoreTest() {

        boolean add = redissonClient.getSet(setKey).add("111");
        boolean add2 = redissonClient.getSet(setKey).add("1112");
        boolean add3 = redissonClient.getSet(setKey).add("1113");
        boolean add4 = redissonClient.getSet(setKey).add("111");
        redissonClient.getSet(setKey).expire(20, TimeUnit.SECONDS);
        log.info("{},{},{},{}", add, add2, add3, add4);
    }

    // redis set 获取值
    @Test
    public void getSet() {

        RSet<Object> set = redissonClient.getSet(setKey);
        log.info("set 值是===");
        Set<String> setStr = new HashSet<>();
        int diff = set.diff("111");
        log.info("==={}", diff);
        for (int i = 0; i < set.size(); i++) {

        }
    }

    final String zSetKey = "ZSET:KEY";

    //zset 放入值与获取值;
    @Test
    public void zSetGet() {
        redissonClient.getScoredSortedSet(zSetKey).addScore(1231,89);
        redissonClient.getScoredSortedSet(zSetKey).addScore(1232,90);
        redissonClient.getScoredSortedSet(zSetKey).addScore(1233,91);
        redissonClient.getScoredSortedSet(zSetKey).addScore(12355,78);
    }
}