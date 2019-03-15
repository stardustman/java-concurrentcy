package com.stardust.java.concurrentcy.container;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class LinkedListConcurrentDemo {

    static class Increament {
        private int i = 0;

        public synchronized int increaseAndGet() {
            return ++i;
        }
    }

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(20);

        final List<Integer> list = new LinkedList<Integer>();
        final Increament increament = new Increament();

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        list.add(increament.increaseAndGet());
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

        System.out.println("list.size():" + list.size());
    }
}