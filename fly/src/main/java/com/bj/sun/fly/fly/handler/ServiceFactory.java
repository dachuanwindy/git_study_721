package com.bj.sun.fly.fly.handler;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/26 19:49
 */

public class ServiceFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    public ServiceFactory(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public T getObject() throws Exception {
        //这里主要是创建接口对应的实例，便于注入到spring容器中
        InvocationHandler handler;
        handler = new ServiceProxy<T>(interfaceType);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class[]{interfaceType}, handler);
    }

    @Override
    public Class<T> getObjectType() {
        return interfaceType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
