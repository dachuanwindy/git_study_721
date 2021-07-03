package com.example.demo.service.operation;

import com.example.demo.service.operation.impl.AddOperation;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/25 01:24
 */
public class OperationFactory implements IOperationFactory {
    @Override
    public Operation createOperation(String type) {
        // 根据不同的type 获取不同的工厂;  每增加一项操作运算,就会修改工厂; 违反了开闭原则
        if (type.equals("加")) {
            return new AddOperation();
        }
        return null;
    }
}
