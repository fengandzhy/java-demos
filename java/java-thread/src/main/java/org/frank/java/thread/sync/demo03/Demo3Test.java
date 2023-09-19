package org.frank.java.thread.sync.demo03;

/**
 * 然而，synchronized可以修饰方法，但它不属于方法的一部分，因此，synchronized关键字不能被继承。如果父类方法使用synchronized关键字，
 * 而子类中覆盖了该方法，则子类这个方法默认是不同步的，必须显式地加上synchronized关键字才会同步。
 * */
public class Demo3Test {
    public static void main(String[] args) {
        MyThreadSynchronized3 myThreadSynchronized = new MyThreadSynchronized3();
        Thread t1 = new Thread(myThreadSynchronized, "t1");
        Thread t2 = new Thread(myThreadSynchronized, "t2");

        t1.start();
        t2.start();
    }
}
