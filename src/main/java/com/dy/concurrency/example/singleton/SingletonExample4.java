package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.NotRecommend;
import com.dy.concurrency.annotations.NotThreadSafe;
import com.dy.concurrency.annotations.ThreadSafe;

@NotThreadSafe
public class SingletonExample4 {
    private SingletonExample4() {

    }
    private static SingletonExample4 instance = null;

    // 静态的工厂方法
    // 双重检测机制。加同步锁。
    // 此时不是线程安全的，由于指令重排现象的存在

    /**
     *  1、memory = allocate() 分配对象的内存空间
     *  2、ctorInstance() 初始化对象
     *  3、instance = memory 设置instance指向刚分配的内存空间
     *  JVM和cpu优化，发生了指令重排
     *  1、3、2
     *  导致：
     *      A执行到31行时，先执行了1、3此时并未初始化，B在28行时认为instance已经不为空，直接返回，出错
     */
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized(SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}

