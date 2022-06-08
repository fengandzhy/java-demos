package org.zhouhy.model.singleton.md01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    
    @Test
    public void test1() throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.write();            
        });
        
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.read();            
        });
        
        t2.start();

        TimeUnit.MILLISECONDS.sleep(1);
        
        t1.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Finished!");
    }
}
