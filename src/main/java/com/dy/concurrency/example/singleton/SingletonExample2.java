package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2() {

    }
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}

