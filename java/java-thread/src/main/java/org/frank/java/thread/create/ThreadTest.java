package org.frank.java.thread.create;

public class ThreadTest {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        
    }
}
