package org.zhouhy.singleton;

/**
 * 1. 线程join的意思就是把指定的线程加入到当前线程中，把当前线程的CPU执行时间让给另一个线程，也就是说在VolatileTest中
 * 在当前主线程中调用t1.join(); t2.join(); 意思是只有等t1 t2执行完成了主线程才继续执行, 没有t1.join(); t2.join();
 * 主线程会直接执行.
 * 
 * 2. volatile关键字保证多线程之间的可见性，这个关键字很有用，在并发包中和Netty框架大量用到这个关键字！
 * 
 * 
 * */
public class SingletonApp {
    public static void main(String[] args) {
        
    }
}
