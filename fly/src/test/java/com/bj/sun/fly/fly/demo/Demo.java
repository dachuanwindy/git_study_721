package com.bj.sun.fly.fly.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunfch
 * @version V1.0
 * @des:
 * @date 2020/3/1 17:54
 */
public class Demo {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int i1 = atomicInteger.incrementAndGet();
                    System.out.println("=====>>>>" + i1 + "=====" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println(atomicInteger.get());

    }
}


// Java 执行顺序，这个比较经典 mark
class A {
    private static A a = new A();

    {
        System.out.println("static");
    }

    static {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }

    static {
        System.out.println("B_B ");
    }

    public static void main(String[] args) {
        B b = new B();

    }
}

class Test2 {
    public static void main(String[] args) {
        long round = Math.round(12.46);
        System.out.println(round);
    }

    static class a {
        public String C() {
            System.out.println("");
            return "";
        }

        private String url = "=====";
    }
}

// 序列化 将对象写入本地，然后再读出来；
class Test3 {
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<String>();
        set.add("11111");
        set.add("22222");
        System.out.println(set);

        String aa = new String("aaaaa");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/opt/set.obj"))) {
            oos.writeObject(set);
        }
        set.clear();
        System.out.println(set);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/opt/set.obj"))) {
            set = (Set<String>) ois.readObject();
        }

        System.out.println(set);
    }
}