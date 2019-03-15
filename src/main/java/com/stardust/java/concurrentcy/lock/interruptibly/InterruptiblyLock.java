package com.stardust.java.concurrentcy.lock.interruptibly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class InterruptiblyLock {
	public static void main(String[] args) throws Exception {
	    final Lock lock = new ReentrantLock();
	
	    Thread t1 = new Thread(new Runnable() {
	        public void run() {
	
	            lock.lock();    //先获取锁
	            try {
	                System.out.println("t1线程获得了锁");
	                try {
	                    Thread.sleep(5000L);    //获取锁之后就休眠
	                } catch (InterruptedException e) {
	                    throw new RuntimeException(e);
	                }
	            } finally {
	                lock.unlock();
	            }
	        }
	    }, "t1");
	    t1.start();
	
	    Thread.sleep(1000L);
	
	    Thread t2 = new Thread(new Runnable() {
	
	        public void run() {
	            try {
	                lock.lockInterruptibly();   //可中断的锁
	                try {
	                    System.out.println("t2线程获得了锁");
	                } finally {
	                	System.out.println("释放lock");
	                    lock.unlock();
	                }
	            } catch (InterruptedException e) {
	                System.out.println("别的线程发送了中断信号，lockInterruptibly立即返回并且抛出异常，这里是处理异常的代码");
	            }
	        }
	    }, "t2");
	    t2.start();
	
	    Thread.sleep(1000L);
	    System.out.println(t2.isInterrupted());
	    t2.interrupt();
	    Thread.sleep(5000L);
	    System.out.println(t2.isInterrupted());
	}
}

