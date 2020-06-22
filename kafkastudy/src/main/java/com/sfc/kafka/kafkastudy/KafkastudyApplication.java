package com.sfc.kafka.kafkastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author sunfch
 * @description: 消息队列, 实现消息队列中
 * <p>
 * 本项目旨在 对kafka有个基本的认识,能正常的接受消息,发送消息
 * <p>
 * 发送顺序消息, 然后能看到每个分区
 * <p>
 * broker             broker     broker   [几个broker就是几个实例]
 * <p>
 * topic   topic
 * <p>
 * partition   partition 就是把一份消息,分到不同的机器上
 * <p>
 * leader---每次都从这里拿数据;
 * follower---
 * @date 2020/6/21 22:56
 */
@SpringBootApplication

public class KafkastudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkastudyApplication.class, args);

    }

}
