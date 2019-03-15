package com.stardust.java.concurrentcy.callable;
public class AddTaskRunnable implements Runnable {

    private int i;

    private int j;

    public AddTaskRunnable(int i, int j) {
        this.i = i;
        this.j = j;
    }


    public void run() {
        int sum = i + j;
        System.out.println("线程t的运算结果：" + sum);
    }
}