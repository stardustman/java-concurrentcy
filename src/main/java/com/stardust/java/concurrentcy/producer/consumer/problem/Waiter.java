package com.stardust.java.concurrentcy.producer.consumer.problem;

import java.util.Queue;

import com.stardust.java.concurrentcy.util.SleepUtil;

class Waiter extends Thread {

    private Queue<Food> queue;

    public Waiter(Queue<Food> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {

            Food food;
            synchronized (queue) {
                while (queue.size() < 1) {
                    try {
                        System.out.println("队列元素个数为： " + queue.size() + "，" + super.getName() + "抽根烟等待中");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                food = queue.remove();
                System.out.println(super.getName() + " 获取到：" + food);
                queue.notifyAll();
            }

            SleepUtil.randomSleep();    //模拟服务员端菜时间
        }
    }
}