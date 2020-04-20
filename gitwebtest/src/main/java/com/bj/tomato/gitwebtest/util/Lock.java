package com.bj.tomato.gitwebtest.util;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 自己实现同步器, 实现锁
 * @date 2020/4/19 20:51
 */
public class Lock implements MyLock, Serializable {


    ReentrantLock reentrantLock = new ReentrantLock();

    private final Sync sync;

    /**
     * @author sunfch
     * @description: 实现公平锁与非公平锁的公共部分
     * @date 2020/4/19 21:50
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {

        /**
         * description: 公平锁与非公平锁都要实现加锁
         *
         * @param
         * @return void
         */
        abstract void lock();


        final boolean nonFairTryAcquire(int acquire) {
            Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }

            } else if (current == getExclusiveOwnerThread()) {
                int next = c + acquire;
                if (next < 0) {
                    throw new Error("");

                }
                setState(next);
                return true;
            }

            return false;
        }


    }

    /**
     * @author sunfch
     * @description: 非公平锁 同步器
     * @date 2020/4/19 21:57
     */
    static class NoFairSync extends Sync {
        private final static long serializdeid = -111100001L;

        /**
         * description:  非公平锁加锁:
         * 1.当对state 修改值得时候成功,将当前线程设置为排他锁;
         * 2 当线程失败就将当前节点放入队列中;
         *
         * @param
         * @return void
         */
        @Override
        void lock() {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                /**
                 * acquire 中做了几件事情
                 * 1-tryacquire失败之后,
                 * 2-将值放入队列中[双向链表中]
                 *   如何放入的? 1.放入尾结点
                 * */
                acquire(1);
            }
        }

        @Override
        protected final boolean tryAcquire(int acquire) {
            return nonFairTryAcquire(acquire);
        }

    }

    /**
     * @author sunfch
     * * @description: 公平锁同步器
     * @date 2020/4/19 21:57
     */
    static class FairSync extends Sync {
        @Override
        void lock() {
            //公平锁:直接放入队列中
            acquire(1);
        }
    }

    /**
     * description:  锁的初始化
     *
     * @param
     * @return
     */
    Lock() {
        sync = new NoFairSync();
    }

    Lock(boolean fire) {
        sync = fire ? new NoFairSync() : new FairSync();
    }

    @Override
    public void lock() {

    }

    /**
     * description: 解锁
     *
     * @return void
     */
    @Override
    public void unLock() {

    }

}
