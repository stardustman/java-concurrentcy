package com.stardust.java.concurrentcy.callable;

public class TestTaskRunnable {
    public static void main(String[] args) {
        AddTaskRunnable task = new AddTaskRunnable(1, 2);
        Thread t = new Thread(task, "t");
        t.start();
    }
}