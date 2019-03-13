package com.stardust.java.concurrentcy.atomic;
public class WrongUsageOfIncrement {

    public static void main(String[] args) {
        final Increment increment = new Increment();

        Thread[] threads = new Thread[20];  //创建20个线程
        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        increment.increase();   //没有进行有效的同步
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