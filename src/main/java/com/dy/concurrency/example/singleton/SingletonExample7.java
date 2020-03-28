package com.dy.concurrency.example.singleton;

import com.dy.concurrency.annotations.Recommend;
import com.dy.concurrency.annotations.ThreadSafe;

@ThreadSafe
@Recommend
public class SingletonExample7 {
    private SingletonExample7(){

    }
    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singleton;
        // JVM保证这个方法绝对只执行一次
        Singleton() {
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}

