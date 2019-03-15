package com.stardust.java.concurrentcy.aqs.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread t = new Thread(new Runnable() {

            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    System.out.println("原来的栅栏遭到了破坏，抛出了BrokenBarrierException异常");
                    return;
                }
                System.out.println("在线程t中输出一句话");
            }
        }, "t");
        t.start();


        try {
            Thread.sleep(1000L);    //确保线程t已经运行了await方法，实际操作中不鼓励使用sleep方法来控制执行顺序
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cyclicBarrier.reset();  //重置cyclicBarrier，弃用原来的栅栏

        new Thread(new Runnable() {

            public void run() {
                try {
                    cyclicBarrier.await();  //线程t2调用重置后的cyclicBarrier的await方法
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("在线程t2中输出一句话");
            }
        }, "t2").start();

        try {
            cyclicBarrier.await();  //线程main调用重置后的cyclicBarrier的await方法
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("在线程main中输出一句话");
    }
}