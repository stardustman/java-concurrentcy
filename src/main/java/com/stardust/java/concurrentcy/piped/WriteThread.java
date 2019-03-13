package com.stardust.java.concurrentcy.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

class WriteThread extends Thread {

	//维护一个输出流
    private PipedOutputStream out;

    public WriteThread(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        byte[] bytes = {1, 2, 3, 4, 5};
        try {
            out.write(bytes);   //向输出流写入数据
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}