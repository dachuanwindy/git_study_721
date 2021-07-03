package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/24 11:51
 */
@RestController
@RequestMapping("test")
public class RiskMindController {

    @RequestMapping(value = "/riskRemind")
    public String riskRemindStr() {
        return "HH";
    }
}
