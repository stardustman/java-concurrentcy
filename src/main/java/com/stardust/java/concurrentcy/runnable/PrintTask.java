package com.stardust.java.concurrentcy.runnable;

/**
 * 任务和线程分开
 * @author young
 *
 */
public class PrintTask implements Runnable {

	public void run() {
		System.out.println("this is a print task");

	}

}
