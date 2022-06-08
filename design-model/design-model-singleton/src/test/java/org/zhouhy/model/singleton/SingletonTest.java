package org.zhouhy.model.singleton;

import org.junit.Test;
import org.zhouhy.model.singleton.md01.LazySafe;
import org.zhouhy.model.singleton.md02.Hungary;

public class SingletonTest {
    
    @Test
    public void test1(){
        for (int i = 0; i < 100; i++) {            
            new Thread(() -> {
                System.out.println(LazySafe.getInstance().hashCode());
            }).start();
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Hungary.getInstance().hashCode());
            }).start();
        }
    }
}
