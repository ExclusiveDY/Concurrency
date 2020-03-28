package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {

    }
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法
    // 双重检测机制。加同步锁。
    // 此时不是线程安全的，由于指令重排现象的存在

    /**
     *  1、memory = allocate() 分配对象的内存空间
     *  2、ctorInstance() 初始化对象
     *  3、instance = memory 设置instance指向刚分配的内存空间
     *  JVM和cpu优化，发生了指令重排
     *  volatile + 双重检测机制  ->  限制不许发生指令重排
     */
    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized(SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}

