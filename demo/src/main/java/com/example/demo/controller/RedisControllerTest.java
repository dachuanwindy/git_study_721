package com.example.demo.controller;

import com.example.demo.util.DistributeLock;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/2/18 12:14
 */

@RestController
@RequestMapping("test")
public class RedisControllerTest {

    @Resource
    private RedisTemplate redisTemplate;

    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    @Resource
    DistributeLock distributeLock;

    @RequestMapping("getvalue/{key}")
    public Object getkeyvalue(@PathVariable String lockKey) {

        redisTemplate.opsForValue().set("1112", "我是redis测试");
        Object o = redisTemplate.opsForValue().get("111211111");

        if (distributeLock.lock("123456789")) {
            return "加锁成功";
        }
        return "加锁失败失败";
       /* if(o!= null){
         return "aaaaaaaa";
        }

        redisTemplate.opsForValue().setIfAbsent("key","key222");

        return redisTemplate.opsForValue().get("key").toString();
*/
    }

    @RequestMapping("lua/{key}")
    public String testLua(@PathVariable String key) {

        String UUID = java.util.UUID.randomUUID().toString();

        boolean success = redisTemplate.opsForValue().setIfAbsent(key, UUID, 3, TimeUnit.MINUTES);
        if (!success) {
            System.out.println("锁已存在");
        }
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result = (Long) redisTemplate.execute(redisScript, Collections.singletonList(key), UUID);
        System.out.println(result);
        return result.toString();

    }


    @RequestMapping(value = "redis/op")
    public String redisTest() {
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("123456", "12345678", 10, TimeUnit.SECONDS);
        Boolean aBoolean1 = redisTemplate.opsForValue().setIfAbsent("123456", "12345", 10, TimeUnit.SECONDS);
        return aBoolean.toString() + aBoolean1.toString();
    }


    @RequestMapping(value = "redis/map")
    public String redisMapTest() {

        try {
            Object o = redisTemplate.opsForHash().get("myMap", "sun");
            System.out.println("myMap-->sun--->value()--" + o.toString());
        } catch (Exception e) {
            redisTemplate.opsForHash().put("myMap", "sun", "chuan");
        }

        redisTemplate.opsForHash().put("myMap", "sun", "chuan");
        redisTemplate.opsForHash().put("myMap", "sun1", "chuan");

        Long myMap = redisTemplate.getExpire("myMap");
        Boolean myMap1 = redisTemplate.expire("myMap", 5, TimeUnit.SECONDS);
        System.out.println("set expire time is true ?" + myMap1);
        System.out.println("expire time is -->" + redisTemplate.getExpire("myMap"));

        System.out.println(myMap + " time ");
        Object o2 = redisTemplate.opsForHash().get("myMap", "sun");
        return o2.toString();
    }
}
