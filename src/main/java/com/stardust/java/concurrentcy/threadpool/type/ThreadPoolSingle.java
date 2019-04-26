package com.stardust.java.concurrentcy.threadpool.type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolSingle {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            });
        }
    }
}