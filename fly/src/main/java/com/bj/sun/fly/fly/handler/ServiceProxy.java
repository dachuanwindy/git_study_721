package com.bj.sun.fly.fly.handler;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * <p>
 * 参考链接https://blog.csdn.net/lichuangcsdn/article/details/89694363
 * @date 2020/6/26 19:46
 */
public class ServiceProxy<T> implements InvocationHandler {

    private Class<T> interfaceType;

    public ServiceProxy(Class<T> intefaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        System.out.println("调用前，参数：{}" + args);
        //这里可以得到参数数组和方法等，可以通过反射，注解等，进行结果集的处理
        //mybatis就是在这里获取参数和相关注解，然后根据返回值类型，进行结果集的转换
        Object result = JSON.toJSONString(args);
        System.out.println("调用后，结果：{}" + result);
        return result;
    }
}
