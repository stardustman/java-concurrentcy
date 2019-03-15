package com.stardust.java.concurrentcy.container;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class VectorConcurrentDemo {

    static class Increament {
        private int i = 0;

        public synchronized int increaseAndGet() {
            return ++i;
        }
    }

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(20);

        final Vector<Integer> vector = new Vector<Integer>();
        final Increament increament = new Increament();

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        vector.add(increament.increaseAndGet());
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("list.size():" + vector.size());
    }
}