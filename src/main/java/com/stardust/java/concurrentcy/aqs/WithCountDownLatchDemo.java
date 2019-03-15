package com.stardust.java.concurrentcy.aqs;
import java.util.concurrent.CountDownLatch;
/**
 * 我们看到，我们在创建CountDownLatch对象的时候传入了Thread数组的大小作为参数，
 * 也就是计数大小为5，然后每次执行完一个任务的时候都调用一下这个CountDownLatch对象的countDown方法，
 * 每调用一下countDown方法计数就会减1，最后在main线程中调用这个CountDownLatch对象的await方法，
 * 在CountDownLatch对象的计数减为0之前，
 * 这个方法会一只等待，直到那5个线程都调用了countDown方法，计数减为0，await方法返回，main线程继续执行。
 * @author young
 *
 */
public class WithCountDownLatchDemo {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        final CountDownLatch countDownLatch = new CountDownLatch(threads.length); //创建CountDownLatch对象

        for (int i = 0; i < threads.length; i++) {

            final int num = i;
            Thread t = new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个线程在执行完任务后，都调用这个方法
                }
            });
            threads[i] = t;
            t.start();
        }

        try {
            countDownLatch.await(); //在threads中线程都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有线程执行完成之后才执行");
    }
}