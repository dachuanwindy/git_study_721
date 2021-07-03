package com.example.demo.service.operation.impl;

import com.example.demo.service.operation.Operation;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 加法类操作
 * @date 2021/4/25 01:19
 */
public class AddOperation implements Operation {
    @Override
    public Integer getResult(int param1, int param2) {
        return param1 + param2;
    }
}
