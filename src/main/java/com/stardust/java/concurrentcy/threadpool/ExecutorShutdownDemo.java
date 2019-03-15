package com.stardust.java.concurrentcy.threadpool;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownDemo {

    private static ExecutorService initExecutorService() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            service.submit(new Runnable() {
                public void run() {
                    System.out.println("第" + num + "个任务开始执行");
                    try {
                        Thread.sleep(3000L);    //休眠5秒
                    } catch (InterruptedException e) {
                        System.out.println("第" + num + "个任务被中断");

                    }
                    System.out.println("第" + num + "个任务执行完成");
                }
            });
        }
        return service;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = initExecutorService();
        /*
        service.shutdown();     //平缓的关闭线程池
        boolean result = service.awaitTermination(10000L, TimeUnit.MILLISECONDS);
        System.out.println("线程池在10秒内进入终止状态是否成功：" + result);*/
        
        List<Runnable> runnables = service.shutdownNow();     //粗暴的关闭线程池
        System.out.println("在阻塞队列中，尚未被执行的任务有：" + runnables);
        boolean result2 = service.awaitTermination(10000L, TimeUnit.MILLISECONDS);
        System.out.println("线程池在10秒内进入终止状态是否成功：" + result2);
    }
}