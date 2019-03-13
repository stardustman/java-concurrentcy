package com.stardust.java.concurrentcy.runnable.exception.handler;

public class UncaughtExceptionHandlerTest {
	public static void main(String[] args) {
		
		//所有线程设置ExceptionHandler
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

		Thread t1 = new Thread(new Runnable() {
			
		    public void run() {
		        throw new RuntimeException("t1的exception");
		    }
		}, "t1");
		
	
		t1.start();
		
		
		
		Thread t2 = new Thread(new Runnable() {
		    public void run() {
		        throw new RuntimeException("t2的exception");
		    }
		}, "t2");
		t2.setUncaughtExceptionHandler(new MyUncaughtExceptionHandlerForTest());
		t2.start();
	}
}

