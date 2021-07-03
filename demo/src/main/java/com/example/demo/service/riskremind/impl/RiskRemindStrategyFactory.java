package com.example.demo.service.riskremind.impl;

import com.example.demo.service.riskremind.RiskRemindStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/24 21:54
 */
@Component
public class RiskRemindStrategyFactory {
    @Autowired
    private List<RiskRemindStrategy> riskRemindStrategy;

    private static Map<String, RiskRemindStrategy> riskRemindStrategyMap;

    @PostConstruct
    public void init() {

        riskRemindStrategy.stream().collect(Collectors.toSet());
    }
}
