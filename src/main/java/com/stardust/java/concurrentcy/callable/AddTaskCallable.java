package com.stardust.java.concurrentcy.callable;
import java.util.concurrent.Callable;

public class AddTaskCallable implements Callable<Integer> {

    private int i;

    private int j;

    public AddTaskCallable(int i, int j) {
        this.i = i;
        this.j = j;
    }


    public Integer call() throws Exception {
        int sum =  i + j;
        System.out.println("线程main的运算结果：" + sum);
        return sum;
    }
}