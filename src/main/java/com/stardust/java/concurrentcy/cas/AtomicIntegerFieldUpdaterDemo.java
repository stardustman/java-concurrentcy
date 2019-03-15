package com.stardust.java.concurrentcy.cas;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    private static class MyObj {
        @SuppressWarnings("unused")
		public volatile int i;

        public MyObj(int i) {
            this.i = i;
        }
    }

    private static AtomicIntegerFieldUpdater<MyObj> updater = AtomicIntegerFieldUpdater.newUpdater(MyObj.class, "i");

    public static void main(String[] args) {
        MyObj myObj = new MyObj(5);
        System.out.println("更新后的值是：" +  updater.incrementAndGet(myObj));
    }
}