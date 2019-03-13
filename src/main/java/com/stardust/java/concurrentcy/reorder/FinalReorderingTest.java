package com.stardust.java.concurrentcy.reorder;

public class FinalReorderingTest {

	public static void main(String[] args) throws InterruptedException {
		Thread readThread = new Thread(new Runnable() {
			
			public void run() {
				FinalReordering.read();
				
			}
		});
		
		Thread writeThread = new Thread(new Runnable() {
			
			public void run() {
				FinalReordering.write();
				
			}
		});
		
		
		writeThread.start();
		Thread.sleep(1000L);
		readThread.start();

	}

}
