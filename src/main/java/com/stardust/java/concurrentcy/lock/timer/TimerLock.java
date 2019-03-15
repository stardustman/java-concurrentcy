package com.stardust.java.concurrentcy.lock.timer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimerLock {
	public static int counter = 0;
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		try {
		    boolean result = lock.tryLock(1000L, TimeUnit.MILLISECONDS);
		    if (result) {   //在指定时间内获取锁成功
		        try {
		            // ... 获取到锁的代码
		        } finally {
		            lock.unlock();  //释放锁
		        }

		    } else {   //在指定时间内获取锁失败
		        // ... 获取锁失败的代码

		    }
		} catch (InterruptedException e) {
		  
	}
}
}

