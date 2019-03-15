package com.stardust.java.concurrentcy.lock.readwrite;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();   //读锁

    private Lock writeLock = readWriteLock.writeLock(); //写锁

    private int i;

    public int getI() {
        readLock.lock();
        try {
            return i;
        } finally {
            readLock.unlock();
        }
    }

    public void setI(int i) {
        writeLock.lock();
        try {
            this.i = i;
        } finally {
            writeLock.unlock();
        }
    }
    
    public static void main(String[] args) {
    	final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		for(int i=0;i<100;i++){
			new Thread(new Runnable() {
				
				public void run() {
					
				}
			}).start();
		}
		System.out.println(demo.getI());
	}
}