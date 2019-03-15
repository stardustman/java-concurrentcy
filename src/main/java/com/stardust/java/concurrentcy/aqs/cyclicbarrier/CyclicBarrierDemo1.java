package com.stardust.java.concurrentcy.aqs.cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class Fighter extends Thread{

    private CyclicBarrier cyclicBarrier;

    public Fighter(CyclicBarrier cyclicBarrier, String name) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);    //模拟上学中过程
            System.out.println(getName() + "放学了，向学校门跑去");

            cyclicBarrier.await();  //到达校门后等待，直到5个线程都执行到了这里

            System.out.println(getName() + "人聚齐了，一起打架去喽～");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CyclicBarrierDemo1 {

    public static void main(String[] args) {

        //CyclicBarrier cyclicBarrier = new CyclicBarrier(6);
    	//CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    	CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        new Fighter(cyclicBarrier, "狗哥").start();
        new Fighter(cyclicBarrier, "猫爷").start();
        new Fighter(cyclicBarrier, "王尼妹").start();
        new Fighter(cyclicBarrier, "狗剩").start();
        new Fighter(cyclicBarrier, "张大嘴巴").start();
    }
}