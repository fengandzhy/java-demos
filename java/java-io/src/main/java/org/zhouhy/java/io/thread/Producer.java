package org.zhouhy.java.io.thread;

import java.io.IOException;
import java.io.PipedWriter;

public class Producer extends Thread{
    
    private PipedWriter writer;
    
    public Producer(PipedWriter writer){
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            writer.write("Hello world!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
