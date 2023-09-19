package org.frank.java.thread.sync.demo01;

public class Demo1Test {

    
    public static void main(String[] args) {
        MyThreadSynchronized1 myThreadSynchronized = new MyThreadSynchronized1();
        Thread t1 = new Thread(myThreadSynchronized, "t1");
        Thread t2 = new Thread(myThreadSynchronized, "t2");
        
        t1.start();
        t2.start();
    }
}
