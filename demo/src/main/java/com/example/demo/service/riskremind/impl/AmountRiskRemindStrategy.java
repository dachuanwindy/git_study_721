package com.example.demo.service.riskremind.impl;

import com.example.demo.service.operation2.AddOperationFactory;
import com.example.demo.service.operation2.IOperationFactory;
import com.example.demo.service.operation2.Operation;
import com.example.demo.service.riskremind.RiskRemindStrategy;
import org.springframework.stereotype.Service;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/24 21:51
 */
@Service
public class AmountRiskRemindStrategy implements RiskRemindStrategy {
    @Override
    public String StrategyName() {
        return null;
    }

    @Override
    public String riskRemind() {

        // 先获取工厂方法,然后从方法中获取实际的操作类, 实际上是抽象了工厂,
        IOperationFactory operationFactory = new AddOperationFactory();
        Operation operation = operationFactory.createOperation();
        Integer result = operation.getResult(1, 1);



        return null;
    }
}
