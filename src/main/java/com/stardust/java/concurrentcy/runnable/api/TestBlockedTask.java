package com.stardust.java.concurrentcy.runnable.api;
public class TestBlockedTask {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = new BlockedTask();     //创建一个阻塞任务
        Thread t = new Thread(task, "t");  //创建一个线程

        t.start();  //开始运行线程t
        Thread.sleep(10L);

        t.interrupt();   //中断线程t
    }
}