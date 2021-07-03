package com.bj.tomato.myservice.myservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/26 18:43
 */
@RestController
public class AppController {
    @GetMapping("producer")
    public String method() {
        return "hhhhh";
    }
}
