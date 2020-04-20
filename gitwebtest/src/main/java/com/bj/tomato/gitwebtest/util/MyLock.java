package com.bj.tomato.gitwebtest.util;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 定义好接口
 * @date 2020/4/19 20:57
 */
public interface MyLock {


    /**
     * description: 实现加锁
     *
     * @param
     * @return void
     */
    void lock();

    /**
     * description: 解锁
     *
     * @param
     * @return void
     */
    void unLock();


}
