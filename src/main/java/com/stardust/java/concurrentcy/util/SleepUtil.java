package com.stardust.java.concurrentcy.util;

import java.util.Random;

public class SleepUtil {

    private static Random random = new Random();

    public static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void sleep(long s){
    	try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}