package com.stardust.java.concurrentcy.runnable.exception.handler;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
	        System.out.println("所有线程的exception handler");
	        System.out.println("抛出异常的线程名： " + t.getName());
	        System.out.println("抛出的异常是： " + e);
	    }


}
