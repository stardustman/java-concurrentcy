package com.stardust.java.concurrentcy.threadpool.rejectpolicy;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CallerRunsPolicy implements RejectedExecutionHandler {
    public CallerRunsPolicy() { }
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    	//线程池未关闭
        if (!e.isShutdown()) {
                r.run();
        }
    }
}