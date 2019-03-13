package com.stardust.java.concurrentcy.runnable;

public class SleepTask implements Runnable {

	public void run() {
		 System.out.println(1);

		    try {
		    	//当前线程休眠1S
		        Thread.sleep(1000L);
		    } catch (InterruptedException e) {
		        throw new RuntimeException(e);
		    }

		    System.out.println(2);

		    try {
		        Thread.sleep(1000L);
		    } catch (InterruptedException e) {
		        throw new RuntimeException(e);
		    }

		    System.out.print(3);

	}

}
