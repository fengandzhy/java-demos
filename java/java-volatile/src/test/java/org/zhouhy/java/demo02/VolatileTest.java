package org.zhouhy.java.demo02;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    
    @Test
    public void test1() throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();

        Thread t1 = new Thread(() -> {            
            demo.write();
        });

        Thread t2 = new Thread(() -> {            
            demo.read();
        });

        t2.start();

        TimeUnit.MILLISECONDS.sleep(2000);

        t1.start();
        t1.join();
        t2.join();

        System.out.println("Finished!");
    }
}
