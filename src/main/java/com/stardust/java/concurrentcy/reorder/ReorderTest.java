package com.stardust.java.concurrentcy.reorder;
/**
 * cpu乱序执行
 * @author young
 *
 */
public class ReorderTest {

	    private static volatile boolean flag;
	    private static int num;

	    public static void main(String[] args) throws InterruptedException {
	        Thread t1 = new Thread(new Runnable() {

	            public void run() {
	                while (!flag) {
	                    Thread.yield();
	                }

	                System.out.println(num);
	            }
	        }, "t1");
	        t1.start();
			flag = true;
			//Thread.sleep(1000L);
			num = 5;

	        
	        
	    }
}
