package com.dy.concurrency.example.syncContainer;

import com.dy.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

@Slf4j
@NotThreadSafe
public class VectorExample3 {
    // 建议在遍历过程中遇到要删除的先进行标记下来，遍历结束之后再删除，否则容易出错
    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) {  // for each
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }
    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) {  // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(3)) {
                v1.remove(iterator.next());
            }
        }
    }
    // success
    private static void test3(Vector<Integer> v1) {  // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
