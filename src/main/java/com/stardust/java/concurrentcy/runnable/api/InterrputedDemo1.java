package com.stardust.java.concurrentcy.runnable.api;
public class InterrputedDemo1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                while (true) {
                	System.out.println("===>没有别的线程把t1的中端状态设置为true");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("有别的线程把线程t1的中断状态变为true，退出循环");
                        break;
                    }
                }
            }
        }, "t1");

        t1.start();
        System.out.println("线程t1是否处于中断状态：" + t1.isInterrupted());

        System.out.println("在main线程中给t1线程发送中断信号");
        t1.interrupt();

        System.out.println("现在线程t1是否处于中断状态：" + t1.isInterrupted());

    }
}