package com.stardust.java.concurrentcy.runnable.api;
public class VolatileStopDemo {

    private static class Task implements Runnable {

        private volatile boolean flag = false;

        public void cancel() {
            flag = true;
        }

      
        public void run() {

            System.out.println("开始执行任务");
            int i = 0;
            while (!flag) {  //检查标识
                if (i % 10000 == 0) {
                    System.out.println(i);
                }
                i++;
            }
            System.out.println("任务执行完成");
        }
    }

    public static void main(String[] args)  throws InterruptedException {
        Runnable task = new Task();     //创建一个任务
        Thread t = new Thread(task, "t");  //创建一个线程

        t.start();  //开始运行线程t
        Thread.sleep(10L);

        ((Task) task).cancel();   //建议执行task的任务停止执行
    }
}