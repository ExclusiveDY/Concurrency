package com.dy.concurrency.example.immutable;

import com.dy.concurrency.annotations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();
    static{
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "2";
//        map = Maps.newHashMap();
        map.put(1, 10);
        log.info("{}", map.get(1));
    }
    private void test(final int a) {
//        a = 1;
    }
}
