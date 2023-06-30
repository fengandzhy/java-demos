package org.frank.java.io;

import org.frank.java.io.thread.Consumer;
import org.frank.java.io.thread.Producer;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;


/**
 * 1 PipedWriter / PipedReader 是用在两个线程之间通信的, 首先要这种方式两者关联, reader.connect(writer);
 * 2 然后在Producer里面无论Producer线程是否结束, Consumer都可以读取Producer里的数据.
 * 
 * */
public class PipedReaderTest {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        
        reader.connect(writer);
        Consumer consumer = new Consumer(reader);
        Producer producer = new Producer(writer);
        
        producer.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();       
    }
}
