package com.stardust.java.concurrentcy.threadfactory;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private static int COUNTER = 0;

    private static String THREAD_PREFIX = "myThread";

    public Thread newThread(Runnable r) {
        int i = COUNTER++;
        return new Thread(r, THREAD_PREFIX + i);
    }
    
    public static void main(String[] args) {
		Thread t = new MyThreadFactory().newThread(new Runnable() {
			
			public void run() {
				System.out.println("test");
				
			}
		});
		System.out.println(t.getName());
	}
}