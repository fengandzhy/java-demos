package org.frank.java.thread.sync.demo04;

/**
 * 所以，synchronized修饰静态方法，锁定的是整个类的所有对象。
 * */
public class Demo4Test {
    public static void main(String[] args) {        
        Thread t1 = new Thread(new MyThreadSynchronized4(), "t1");
        Thread t2 = new Thread(new MyThreadSynchronized4(), "t2");
        t1.start();
        t2.start();
    }
}
