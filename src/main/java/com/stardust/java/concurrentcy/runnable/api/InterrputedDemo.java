package com.stardust.java.concurrentcy.runnable.api;
public class InterrputedDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(100000L);  //调用sleep方法阻塞
                } catch (InterruptedException e) {
                    System.out.println("sleep方法抛出异常，现在t1线程的中断状态为：" + Thread.currentThread().isInterrupted());
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