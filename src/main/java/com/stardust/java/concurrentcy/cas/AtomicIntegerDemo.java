package com.stardust.java.concurrentcy.cas;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println("atomicInteger代表的int值是：" + atomicInteger.get());
        System.out.println("atomicInteger自增1之后的值是：" + atomicInteger.incrementAndGet());

        boolean result = atomicInteger.compareAndSet(2, 3);
        System.out.println("atomicInteger比较并交换的执行成功了么：" + result + " 结果是：" + atomicInteger.get());

    }
}