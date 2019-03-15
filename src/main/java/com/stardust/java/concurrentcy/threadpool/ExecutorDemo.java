package com.stardust.java.concurrentcy.threadpool;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
//把任务的提交和执行解耦开来了
public class ExecutorDemo {
	//任务提交
	public void process(List<Runnable> runnables) {
	    Executor executor = Executors.newFixedThreadPool(10);      //创建包含10个线程的执行器
	    //任务执行
	    for (Runnable r : runnables) {
	        executor.execute(r);    //提交任务
	    }
	}
}

