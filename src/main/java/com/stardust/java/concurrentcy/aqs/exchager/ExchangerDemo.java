package com.stardust.java.concurrentcy.aqs.exchager;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new Runnable() {


            public void run() {
                String manWords = "我爱你，si八婆";
                try {
                    String womanWords = exchanger.exchange(manWords);   //男方的誓言
                    System.out.println("在男方线程中获取到的女方誓言：" + womanWords);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "男方").start();

        new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(5000L);    //女生先墨迹5秒中
                    String womanWords = "去吃屎吧";
                    String manWords = exchanger.exchange(womanWords);   //女方的誓言
                    System.out.println("在女方线程中获取到的男方誓言：" + manWords);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "女方").start();

    }
}