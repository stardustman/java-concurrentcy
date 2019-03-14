package com.stardust.java.concurrentcy.deadlock;

import com.stardust.java.concurrentcy.util.LockUtil;

public class DeadLockDemo {

    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        new Thread(new Runnable() {

            public void run() {

                while (true) {
                    synchronized (lock1) {
                        System.out.println("线程t1获取了 lock1锁");
                        LockUtil.sleep(1000L);

                        synchronized (lock2) {
                            System.out.println("线程t1获取了 lock2锁");
                        }
                    }
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            public void run() {

                while (true) {
                    synchronized (lock2) {
                        System.out.println("线程t2获取了 lock2锁");
                        LockUtil.sleep(1000L);

                        synchronized (lock1) {
                            System.out.println("线程t2获取了 lock1锁");
                        }
                    }
                }
            }
        }, "t2").start();
    }
}