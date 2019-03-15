package com.stardust.java.concurrentcy.threadpool;

import java.util.concurrent.Executor;

public class ThreadPerRunnalbeExecutor implements Executor {
 
   

	public void execute(Runnable command) {
		 new Thread(command).start();
		
	}

	
}