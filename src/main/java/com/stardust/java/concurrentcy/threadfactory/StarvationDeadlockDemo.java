package com.stardust.java.concurrentcy.threadfactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StarvationDeadlockDemo {


    private static ExecutorService service = Executors.newSingleThreadExecutor();

    private static class Task1 implements Callable<String> {
     
        public String call() throws Exception {
            System.out.println("开始执行task1");
            Future<String> future = service.submit(new Task2());
            System.out.println("task2的执行结果是：" + future.get());
            return "task1";
        }
    }

    private static class Task2 implements Callable<String> {
        
        public String call() throws Exception {
            System.out.println("开始执行task2");
            return "task2";
        }
    }

    public static void main(String[] args) {
        service.submit(new Task1());
    }
}