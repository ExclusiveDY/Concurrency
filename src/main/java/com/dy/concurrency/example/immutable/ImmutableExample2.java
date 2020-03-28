package com.dy.concurrency.example.immutable;

import com.dy.concurrency.annotations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static{
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3); // 会抛出异常

    }

}
