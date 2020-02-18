package com.bj.tomato.gitwebtest.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunfch
 * @version V1.0
 * @Description: Redis集成有三种方式 第一 jderis 第二：redission 第三种：redistemplate
 * 目前想用第二种方式
 * @date 2020/1/12 00:05
 */
@Configuration
public class Redisconfig {


    @Bean
    RedissonClient redisClient() {
        Config config = new Config();
        config.useSingleServer().setDatabase(2).setAddress("redis://127.0.0.1:6379");

        //Config.fromYAML(RedissonConfig.class.getClassLoader().getResource("redisson-config.yml"));
        // TODO  待redis连接模式确定
        return Redisson.create(config);
    }


}
