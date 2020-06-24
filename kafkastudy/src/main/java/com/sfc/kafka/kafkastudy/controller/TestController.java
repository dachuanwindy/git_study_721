package com.sfc.kafka.kafkastudy.controller;

import com.sfc.kafka.kafkastudy.config.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/22 10:04
 */


@RestController
@RequestMapping(value = "kafka")
public class TestController {


    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private Product product;

    @RequestMapping(value = "send")
    public String data() {

        product.send("aaaaaaaaf");
        return "发送成功";
    }

    @Transactional
    @RequestMapping("tran")
    public String test() {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send("topic.quick.tran", "test executeInTransaction");
                throw new RuntimeException("fail");
                //return true;
            }
        });

        return "执行事务";
    }

}
