package com.dy.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.synth.SynthCheckBoxMenuItemUI;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    public void test1(int j) {
        synchronized(this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} -> {}", j, i);
            }
        }
    }
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 -> {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }

}
