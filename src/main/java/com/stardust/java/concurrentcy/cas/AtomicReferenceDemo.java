package com.stardust.java.concurrentcy.cas;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    private static class MyObj {
        int i;

        public MyObj(int i) {
            this.i = i;
        }
    }

    private static AtomicReference<MyObj> atomicReference = new AtomicReference<MyObj>();

    public static void main(String[] args) {
        MyObj myObj = new MyObj(5);
        atomicReference.set(myObj);
        boolean result = atomicReference.compareAndSet(myObj, new MyObj(6));
        System.out.println("atomicReference的比较并交换成功了么：" + result + " 结果是：" + atomicReference.get().i);
    }
}