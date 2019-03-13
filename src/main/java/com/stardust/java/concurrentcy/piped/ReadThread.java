package com.stardust.java.concurrentcy.piped;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadThread extends Thread {
    
	//维护一个输入流
    private PipedInputStream in;

    public ReadThread(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {

        int i = 0;
        try {
            while ((i=in.read()) != -1) {   //从输入流读取数据
                System.out.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
