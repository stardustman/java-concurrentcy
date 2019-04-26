package com.stardust.java.concurrentcy.threadpool.rejectpolicy;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class AbortPolicy implements RejectedExecutionHandler {
    public AbortPolicy() { }
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
    }
	
	
}