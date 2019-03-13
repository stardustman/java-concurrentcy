package com.stardust.java.concurrentcy.wait.notify.mechanism;
public class Test {

    public static void main(String[] args) {

        Washroom washroom = new Washroom();

        new Thread(new ShitTask(washroom, "狗哥"), "BROTHER-DOG-THREAD").start();
        new Thread(new ShitTask(washroom, "猫爷"), "GRANDPA-CAT-THREAD").start();
        new Thread(new ShitTask(washroom, "王尼妹"), "WANG-NI-MEI-THREAD").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(new RepairTask(washroom), "REPAIR-THREAD").start();
    }
}