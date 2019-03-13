package com.stardust.java.concurrentcy.runnable;

/**
 * 任务和线程耦合
 * @author young
 *
 */
public class PrintThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("this is a print task implement by extends Thread");
	}

}
