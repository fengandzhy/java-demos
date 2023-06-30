package org.frank.java.demo03;

import org.junit.Test;

public class VolatileTest1 {
    
    @Test
    public void test1(){       
        for(int i=0;i<10;i++){
            new Thread(()->{
                VolatileDemo1.addCount();
            }).start();
        }
    }
}
