package org.zhouhy.proxy.extralogic;

public class Task {
    
    public void begin(String name,String thing){
        System.out.println(name + " begins "+thing);
    }

    public void end(String name,String thing){
        System.out.println(name + " finished "+thing);
    }
}
