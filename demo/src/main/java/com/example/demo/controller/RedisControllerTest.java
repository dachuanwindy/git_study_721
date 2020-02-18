package com.example.demo.controller;

import com.example.demo.util.DistributeLock;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


    @Resource
    DistributeLock distributeLock;

    @RequestMapping("getvalue")
    public Object getkeyvalue() {

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
}
