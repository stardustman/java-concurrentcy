package com.stardust.java.concurrentcy.threadpool.type;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ThreadPoolScheduled {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            }, 10, TimeUnit.SECONDS);
        }
    }
}