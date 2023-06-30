package org.frank.java.io.thread;

import java.io.IOException;
import java.io.PipedReader;

public class Consumer extends Thread{
    
    private PipedReader reader;
    
    public Consumer(PipedReader reader){
        this.reader = reader;
    }

    @Override
    public void run() {
        char[] chars = new char[20];
        try {            
            int len = reader.read(chars,0,chars.length);
            System.out.println(new String(chars,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
