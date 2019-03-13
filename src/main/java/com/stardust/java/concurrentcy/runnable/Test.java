package com.stardust.java.concurrentcy.runnable;
public class Test {

    public static void main(String[] args) {
        new Thread(new PrintTask()).start();
        new PrintThread().start();
    }
}