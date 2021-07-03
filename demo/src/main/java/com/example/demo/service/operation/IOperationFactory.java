package com.example.demo.service.operation;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 操作类工厂, 通过工厂获取相应的操作类
 * @date 2021/4/25 01:17
 */
public interface IOperationFactory {

    /**
     * 获取或者创建操作类:获取加,减,乘,除
     *
     * @return
     */
    Operation createOperation(String type);
}
