package com.stardust.java.concurrentcy.cas;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1, 3, 5, 7, 9});

    public static void main(String[] args) {
        System.out.println("atomicIntegerArray代表的int数组第1号元素是：" + atomicIntegerArray.get(1));
        System.out.println("atomicIntegerArray第1号元素自增1之后的值是：" + atomicIntegerArray.incrementAndGet(1));

        boolean result = atomicIntegerArray.compareAndSet(1, 4, 5);
        System.out.println("atomicIntegerArray对第1号元素的比较并交换的执行成功了么：" + result + " 结果是：" + atomicIntegerArray.get(1));
    }
}