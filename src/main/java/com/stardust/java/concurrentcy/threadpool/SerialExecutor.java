package com.stardust.java.concurrentcy.threadpool;

import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {

    public void execute(Runnable r) {
        r.run();
    }

	
}