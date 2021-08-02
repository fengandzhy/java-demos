package org.zhouhy.model.singleton;

/**
 * 1. 线程join的意思就是把指定的线程加入到当前线程中，把当前线程的CPU执行时间让给另一个线程，也就是说在VolatileTest中
 * 在当前主线程中调用t1.join(); t2.join(); 意思是只有等t1 t2执行完成了主线程才继续执行, 没有t1.join(); t2.join();
 * 主线程会直接执行.
 * 
 * 
 * 
 * 
 * */
public class SingletonApp {
    public static void main(String[] args) {
        
    }
}
