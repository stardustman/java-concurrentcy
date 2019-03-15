package com.stardust.java.concurrentcy.aqs.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            final int num = i;
            new Thread(new Runnable() {

                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("第" + num + "个线程执行任务");
                        Thread.sleep(5000L);    //休眠5秒钟
                        semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }).start();
        }
    }
}