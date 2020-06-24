package com.sfc.kafka.kafkastudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 生产者
 * @date 2020/6/22 07:54
 */
@Component
public class Product {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String name) {
        String dataBody = "这个是第一次实现kafka";
        kafkaTemplate.send("user", dataBody);

    }
}