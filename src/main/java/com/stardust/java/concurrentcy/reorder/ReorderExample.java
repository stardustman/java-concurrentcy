package com.stardust.java.concurrentcy.reorder;
public class ReorderExample{
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String args[]) throws InterruptedException{
        Thread one = new Thread(){
             @Override
             public void run(){
                 a = 1;
                 x = b;
             }

        };

        Thread other = new Thread(){
            @Override
            public void run(){
                b = 1;
                y = a;
            }
        };

        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println(String.format("x = %s, y = %s", x,y));
    }
    
}