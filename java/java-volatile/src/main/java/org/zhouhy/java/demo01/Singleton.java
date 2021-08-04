package org.zhouhy.java.demo01;

public class Singleton {
    
    private static volatile Singleton singleton;
    
    private Singleton(){
        
    }
    
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (singleton){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }        
        return singleton;
    }
}
