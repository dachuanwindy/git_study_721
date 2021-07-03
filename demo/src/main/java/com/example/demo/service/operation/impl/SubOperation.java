package com.example.demo.service.operation.impl;

import com.example.demo.service.operation.Operation;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 减法操作
 * @date 2021/4/25 01:21
 */
public class SubOperation implements Operation {
    @Override
    public Integer getResult(int param, int param2) {
        return param - param2;
    }
}
