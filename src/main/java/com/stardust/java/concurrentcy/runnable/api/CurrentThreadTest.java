package com.stardust.java.concurrentcy.runnable.api;
public class CurrentThreadTest {

    public static void main(String[] args) {
        new CurrentThreadTest().shareMethod();

        new Thread(new Runnable() {
            public void run() {
                new CurrentThreadTest().shareMethod();
            }
        }, "t1").start();

        new Thread(new Runnable() {
            public void run() {
                new CurrentThreadTest().shareMethod();
            }
        }, "t2").start();
    }

    public void shareMethod() {
        Thread thread = Thread.currentThread();
        System.out.println("当前正在执行的线程名称：" + thread.getName());
    }
}