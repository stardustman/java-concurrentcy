package com.stardust.java.concurrentcy.atomic;

public class SynchronizedMethod {


	    public void increase() {
	        synchronized (this) {   //使用this作为锁
	        	
	        }
	    }

	    public static void anotherStaticMethod() {
	        synchronized (Increment.class) {   //使用Class对象作为锁
	            // 此处填写需要同步的代码块
	        }
	    }
	    
	    public synchronized void increaseSimple() {   //使用this作为锁
	        
	    }

	    public synchronized static void anotherStaticMethodSimple() {   //使用Class对象作为锁
	        // 此处填写需要同步的代码块
	    }
}
