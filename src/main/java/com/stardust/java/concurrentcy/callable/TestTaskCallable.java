package com.stardust.java.concurrentcy.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTaskCallable {
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();    //创建一个线程池
        Future<Integer> future = service.submit(new AddTaskCallable(1, 2)); //提交一个任务
        int result = future.get();  //在任务执行完成之前，该方法将一直阻塞
        System.out.println("线程main提交到线程池的运算结果是：" + result);
    }
}