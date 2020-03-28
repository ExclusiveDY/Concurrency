package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1() {

    }
    private static SingletonExample1 instance = null;

    // 静态的工厂方法
    // 单线程下没有问题，多线程下有问题
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}

