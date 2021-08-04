package org.zhouhy.java.demo02;

public class VolatileDemo {

    volatile  int x =0;
    volatile  boolean b = false;

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
