package com.stardust.java.concurrentcy.aqs;
public class NoCountDownLatchDemo {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {

            final int num = i;
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                }
            });
            threads[i] = t;
            t.start();
        }

        for (int i = 0; i < threads.length; i++) {  //等待所有线程执行完才可以执行main线程
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("等待所有线程执行完成之后才执行");
    }
}