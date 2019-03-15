package com.stardust.java.concurrentcy.runnable.api;
public class ThreadStopDemo {

    private static class Task implements Runnable {

        public void run() {
            System.out.println("开始执行任务");
            boolean flag = true;
            int i = 0;
            while (flag) {  //死循环
                if (i % 10000 == 0) {
                    System.out.println(i);
                }
                i++;
            }
            System.out.println("任务执行完成");
        }
    }

    @SuppressWarnings("deprecation")
	public static void main(String[] args)  throws InterruptedException {
        Runnable task = new Task();     //创建一个任务
        Thread t = new Thread(task, "t");  //创建一个线程

        t.start();  //开始运行线程t
        Thread.sleep(10L);

        t.stop();   //停止线程t的执行
    }
}