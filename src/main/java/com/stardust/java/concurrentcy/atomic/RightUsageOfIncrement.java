package com.stardust.java.concurrentcy.atomic;
public class RightUsageOfIncrement {

    public static void main(String[] args) {
        final Increment increment = new Increment();

        Thread[] threads = new Thread[20];  //创建20个线程
        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        synchronized (RightUsageOfIncrement.class) {    // 使用Class对象加锁
                            increment.increase();
                        }
                    }
                }
            });
            threads[i] = t;
            t.start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(increment.getI());
    }
}