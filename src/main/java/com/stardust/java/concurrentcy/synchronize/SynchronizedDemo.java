package com.stardust.java.concurrentcy.synchronize;
public class SynchronizedDemo {

    private Object lock = new Object();

    public void m1() {
        synchronized (lock) {
            System.out.println("这是第一个方法");
            m2();
        }
    }

    public void m2() {
        synchronized (lock) {
            System.out.println("这是第二个方法");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.m1();
    }
}