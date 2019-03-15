package com.stardust.java.concurrentcy.aqs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        final Queue<Runnable> runnableQueue = new LinkedList<Runnable>();
        final CountDownLatch countDownLatch = new CountDownLatch(5); //创建CountDownLatch对象

        for (int i = 0; i < 5; i++) {

            final int num = i;
            Runnable runnable = new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个任务执行完成之后，都调用这个方法
                }
            };

            runnableQueue.add(runnable);
        }


        for (int i = 0; i < 2; i++) {   //创建两个线程来执行上边的5个任务
            new Thread(new Runnable() {

                public void run() {
                    while (true) {
                        Runnable runnable = null;
                        synchronized (CountDownLatchDemo.class) {   //runnableQueue的相关操作需要进行同步处理
                            if (runnableQueue.size() < 1) {
                                break;
                            }

                            runnable = runnableQueue.remove();
                        }
                        runnable.run(); //执行该任务
                    }
                }
            }).start();
        }

        try {
            countDownLatch.await(); //在runnableQueue中的所有任务都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有任务执行完成之后才执行");
    }
}