package com.stardust.java.concurrentcy.runnable.api;

public class ThreadJoinTest {
      public static void main(String[] args) {
    	  final Thread t1 = new Thread(new Runnable() {
    		    public void run() {
    		        for (int i = 0; i < 5; i++) {
    		            System.out.println(i);
    		            try {
    		                Thread.sleep(1000L);
    		            } catch (InterruptedException e) {
    		                throw new RuntimeException(e);
    		            }
    		        }
    		    }
    		}, "t1");

    		t1.start();

    		Thread t2 = new Thread(new Runnable() {
    		    double d = 1.2d;
    		    public void run() {
    		        try {
    		            t1.join();
    		        } catch (InterruptedException e) {
    		            throw new RuntimeException(e);
    		        }
    		        System.out.println("线程t1执行完了，该t2了");
    		    }
    		});

    		t2.start();
	}
}
