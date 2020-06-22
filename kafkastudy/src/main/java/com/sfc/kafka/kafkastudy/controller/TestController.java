package com.sfc.kafka.kafkastudy.controller;

import com.sfc.kafka.kafkastudy.config.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Product product;

    @RequestMapping(value = "send")
    public String data() {

        product.send("aaaaaaaaf");
        return "发送成功";
    }
}
