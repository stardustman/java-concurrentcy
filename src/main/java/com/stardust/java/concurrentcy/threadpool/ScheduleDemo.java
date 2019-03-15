package com.stardust.java.concurrentcy.threadpool;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleDemo {

    private static class PrintTask implements Runnable {

        private String s;

        public PrintTask(String s) {
            this.s = s;
        }

     
        public void run() {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        //隔1秒后打印
        service.schedule(new PrintTask("1"), 1, TimeUnit.SECONDS);

        //首次5秒后打印，每隔1秒打印一次
        service.scheduleAtFixedRate(new PrintTask("2"), 5, 1, TimeUnit.SECONDS);
    }
}