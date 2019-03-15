package com.stardust.java.concurrentcy.runnable.api;
public class BlockedTask1 implements Runnable {

    private volatile boolean flag = true;

    public void cancel() {
        flag = false;
    }


    public void run() {
        System.out.println("开始执行任务");

        try {
            while (flag) {
                Thread.sleep(1000000L);     //发生阻塞的操作
            }
        } catch (InterruptedException e) {
            e.printStackTrace();    //打印异常的调用信息
        }

        System.out.println("任务执行完成");
    }
}