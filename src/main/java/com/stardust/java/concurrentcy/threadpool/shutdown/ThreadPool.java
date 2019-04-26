package com.stardust.java.concurrentcy.threadpool.shutdown;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            System.err.println(i);
            pool.execute(() -> {
                try {
                    Thread.sleep(30000);
                    System.out.println("--");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(1000);
        List<Runnable> runs = pool.shutdownNow();
        
        
        System.out.println("threads not executed");
        for (Runnable runnable : runs) {
			System.out.println(runnable);
		}
        
        
        
        
        while(true){  
            if(pool.isTerminated()){  
                System.out.println("所有的子线程都结束了！");  
                break;  
            }  
            Thread.sleep(1000);    
        }  
        
      //关闭后不能再执行task
        pool.execute(() -> {
            try {
                Thread.sleep(30000);
                System.out.println("--");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}