package org.zhouhy.model.singleton;

import org.junit.Test;
import org.zhouhy.model.singleton.md01.LazySafe;

public class SingletonTest {
    
    @Test
    public void test1(){
        for (int i = 0; i < 100; i++) {            
            new Thread(() -> {
                System.out.println(LazySafe.getInstance().hashCode());
            }).start();
        }
    }
}
