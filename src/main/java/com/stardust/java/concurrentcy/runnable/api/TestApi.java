package com.stardust.java.concurrentcy.runnable.api;

import com.stardust.java.concurrentcy.runnable.SleepTask;

public class TestApi {
     public static void main(String[] args) {
    	 
    	 //休眠
    	 new Thread(new SleepTask()).start();
    	 
    	 //线程ID
    	 System.out.println(new Thread().getId());
    	 System.out.println(new Thread().getId());
    	 System.out.println(new Thread().getId());
    	 
    	 //名称
    	 Thread t1 = new Thread("t1");
    	 Thread t2 = new Thread();
    	 t2.setName("t2");
    	 System.out.println("t1线程的名称是：" + t1.getName());
    	 System.out.println("t2线程的名称是：" + t2.getName());
    	 
    	 //优先级
    	 System.out.println("t1线程的优先级是：" + t1.getPriority());
    	 t1.setPriority(Thread.MAX_PRIORITY);
    	 System.out.println("t1线程的优先级是：" + t1.getPriority());
    	 
    	 //是否守护线程
    	 System.out.println("main线程是否是守护线程：" + Thread.currentThread().isDaemon());
    	 System.out.println("t1线程是否是守护线程：" + t1.isDaemon());
    	 t1.setDaemon(true);
    	 System.out.println("t1线程是否是守护线程：" + t1.isDaemon());
    	 
    	 //子线程是否是守护线程由父线程决定
    	 Thread t3 = new Thread(new Runnable() {
    	     public void run() {
    	         Thread t4 = new Thread();
    	         System.out.println("从守护线程t3中创建的线程t4是不是守护线程：" + t4.isDaemon());
    	     }
    	 });
    	 t3.setDaemon(true);
    	 t3.start();
    	 
    
    	 
    	 
	}
}
