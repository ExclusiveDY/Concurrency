package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6() {

    }
    // 静态变量声明顺序为执行顺序，若instance声明在初始化后面，则后面会覆盖掉，仍为空，拿不到对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    public static SingletonExample6 getInstance() {
        return instance;
    }
}

