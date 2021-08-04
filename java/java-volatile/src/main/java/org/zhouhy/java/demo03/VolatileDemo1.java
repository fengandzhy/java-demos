package org.zhouhy.java.demo03;

public class VolatileDemo1 {
    
    private volatile static int count = 0;
    
    public static void addCount(){
        for(int i=0;i<1000;i++){
            count++;
        }
        System.out.println("count = "+count);
    }
}
