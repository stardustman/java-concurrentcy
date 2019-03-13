package com.stardust.java.concurrentcy.util;
public class LockUtil {

    public static void sleep(long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}