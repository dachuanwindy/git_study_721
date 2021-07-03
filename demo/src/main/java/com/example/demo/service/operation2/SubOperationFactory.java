package com.example.demo.service.operation2;

import com.example.demo.service.operation2.impl.SubOperation;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/25 01:24
 */
public class SubOperationFactory implements IOperationFactory {

    @Override
    public Operation createOperation() {
        return new SubOperation();
    }
}
