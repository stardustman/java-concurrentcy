package com.stardust.java.concurrentcy.threadpool;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReuseThread {
	public void process(List<Runnable> runnables) {
	    final Queue<Runnable> queue = new ConcurrentLinkedQueue<Runnable>(runnables);   //同步队列
	
	    for (int i = 0; i < 10; i++) {
	        new Thread(new Runnable() {
	
	            public void run() {
	                while (true) {
	                    Runnable r = queue.poll();
	                    if (r == null) {    //如果没任务了就退出
	                        break;
	                    }
	                    r.run();    //执行任务
	                }
	            }
	        }).start();
	    }
	} 
}

