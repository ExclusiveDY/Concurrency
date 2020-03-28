package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.NotRecommend;
import com.dy.concurrency.annotations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3() {

    }
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    // 线程安全了，但是效率变低了，影响性能
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}

