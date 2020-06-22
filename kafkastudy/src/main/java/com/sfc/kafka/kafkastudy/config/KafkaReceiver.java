package com.sfc.kafka.kafkastudy.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 消费者
 * @date 2020/6/22 08:47
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"user"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }

    }
}
