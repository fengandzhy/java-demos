package org.frank.java.thread.sync.demo02;

/**
 * 从结果看，t1和t2是顺序执行的。并发线程访问的是同一对象的不同synchronized代码块，同一时刻仍然只有一个线程能执行，其他线程会阻塞。
 * 原因仍然是synchronized代码锁锁定是调用代码块的对象。
 * */
public class Demo2Test {
    public static void main(String[] args) {
        MyThreadSynchronized2 myThreadSynchronized = new MyThreadSynchronized2();
        Thread t1 = new Thread(myThreadSynchronized, "t1");
        Thread t2 = new Thread(myThreadSynchronized, "t2");

        t1.start();
        t2.start();
    }
}
