package com.bj.tomato.gitwebtest.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 分布式锁实现
 * @date 2020/2/18 11:56
 */
@Component
public class DistributeLock {

    @Autowired
    private RedissonClient redissonClient;

    private static Long time = 60L;


    /**
     * @description: 用于实现分布式锁，业务锁，最多只能锁60s
     * @author sunfch
     * @date 2020/2/18 11:58
     */
    public boolean lock(String keyName) {
        if (Objects.isNull(keyName)) {
            return false;
        }
        RLock lock = redissonClient.getLock(keyName);
        if (lock.isLocked()) {
            return false;
        } else {
            lock.lock(time, TimeUnit.SECONDS);
            return true;
        }
    }
}
