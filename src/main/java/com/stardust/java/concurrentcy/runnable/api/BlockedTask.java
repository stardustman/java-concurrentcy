package com.stardust.java.concurrentcy.runnable.api;
public class BlockedTask implements Runnable {


    public void run() {

        System.out.println("开始执行任务");
        try {
            while (!Thread.currentThread().isInterrupted()) {    //中断状态是为true时退出循环
                System.out.println("進入休眠");
            	Thread.sleep(1000000L);     //发生阻塞的操作
            }
        } catch (InterruptedException e) {
            System.out.println("有别的线程中断了本线程");
        } finally {
            System.out.println("任务执行完成");
        }
    }
}