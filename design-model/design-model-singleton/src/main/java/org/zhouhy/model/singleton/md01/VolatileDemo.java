package org.zhouhy.model.singleton.md01;

public class VolatileDemo {
    int x =0;
    boolean b = false;
    
    public void write(){
        x=5;
        b=true;
    }
    
    public void read(){
        while(!b){
            
        }
        System.out.println("x=>>>"+x);
    }
}
