package com.stardust.java.concurrentcy.aqs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBlockedQueue<E> {

    private Lock lock = new ReentrantLock();

    private Condition emptyCondition = lock.newCondition();

    private Condition fullCondition = lock.newCondition();

    private Queue<E> queue = new LinkedList<E>();

    private int limit;

    public ConditionBlockedQueue(int limit) {
        this.limit = limit;
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public boolean add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (size() >= limit) {
                fullCondition.await();
            }

            boolean result = queue.add(e);
            emptyCondition.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public E remove() throws InterruptedException{
        lock.lock();
        try {
            while (size() == 0) {
                emptyCondition.await();
            }
            E e = queue.remove();
            fullCondition.signalAll();
            return e;
        } finally {
            lock.unlock();
        }
    }
}