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

    		/**
    		 * 需要注意的是，join方法是Thread类的成员方法。
    		 * 上边例子中在main线程中调用t.join()的意思就是，
    		 * 使用Thread对象t作为锁对象，如果t线程还活着，就调用wait()，
    		 * 把main线程放到与t对象关联的等待队列里，直到t线程执行结束，
    		 * 系统会主动调用一下t.notifyAll()，
    		 * 把与t对象关联的等待队列中的线程全部移出，从而main线程可以继续执行～
    		 */
    		Thread t2 = new Thread(new Runnable() {
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
