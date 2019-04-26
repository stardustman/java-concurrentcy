package com.stardust.java.concurrentcy.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolAPI {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        });
        String result = future.get();
        System.out.println(result);
    }
}