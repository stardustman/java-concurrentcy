package com.stardust.java.concurrentcy.producer.consumer.problem;

import java.util.Random;

class SleepUtil {

    private static Random random = new Random();

    public static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}