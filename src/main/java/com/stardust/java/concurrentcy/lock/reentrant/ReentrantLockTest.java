package com.stardust.java.concurrentcy.lock.reentrant;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Random random = new Random();
		
		while (true) {
		    boolean result = lock.tryLock(); //尝试获取锁的操作
		    if (result) {
		        try {
		            // ... 具体代码
		        	System.out.println("get lock");
		        } finally {
		            lock.unlock();
		        }
		    }
		
		    // 获取锁失败后随即休息一段时间后重试
		    try {
		        Thread.sleep(random.nextInt(1000)); //随机休眠1秒内的时间
		    } catch (InterruptedException e) {
		        throw new RuntimeException(e);
		    }
		}
	}
}

