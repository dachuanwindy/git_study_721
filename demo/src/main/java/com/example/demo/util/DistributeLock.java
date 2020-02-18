package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 分布式锁工具类
 * @date 2020/2/18 12:38
 */
@Component
public class DistributeLock {

    @Autowired
    private RedisTemplate redisTemplate;


    public boolean lock(String keyName) {
        //先判断key是否为空
        if (keyName == null) {
            return false;
        }
        // 判断能否获取key,若不为空就是有key-锁
        if (redisTemplate.opsForValue().get(keyName) != null) {
            //这里添加一步,防止锁的时间
            Long expireSeconds = redisTemplate.getExpire(keyName);
            if (expireSeconds == -1) {
                redisTemplate.expire(keyName, 5, TimeUnit.SECONDS);
            }
            return false;
        }
        //若程序走到这里就证明里面是没有锁的，然后加锁；
        try {
            if (redisTemplate.opsForValue().setIfAbsent(keyName, keyName)) {
                redisTemplate.expire(keyName, 5, TimeUnit.SECONDS);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
