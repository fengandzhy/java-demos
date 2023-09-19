package org.frank.java.thread.sync.demo02;


public class Demo2Test {
    public static void main(String[] args) {
        MyThreadSynchronized2 myThreadSynchronized = new MyThreadSynchronized2();
        Thread t1 = new Thread(myThreadSynchronized, "t1");
        Thread t2 = new Thread(myThreadSynchronized, "t2");

        t1.start();
        t2.start();
    }
}
