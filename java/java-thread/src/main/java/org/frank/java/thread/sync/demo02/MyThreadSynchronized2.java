package org.frank.java.thread.sync.demo02;

/**
 * synchronized 就是一把锁, 它与具体的对象相对应, 对于本例中 myThreadSynchronized 对象来说, t1 拿到了它的锁, t2 就只能等待. 
 * 因为t2 也是需要 同一个 myThreadSynchronized 对象的 锁.
 * 
 * */
@SuppressWarnings("DuplicatedCode")
public class MyThreadSynchronized2 implements Runnable{

    private static int count =0;
    
    
    public void increase() {
        synchronized (this) {
            for (int i = 0; i < 3; i++){
                try {
                    System.out.println(Thread.currentThread().getName() + " :" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }            
        }   
    }

    public void printCount() {
        synchronized (this) {
            for (int i = 0; i < 3; i++){
                try {
                    System.out.println(Thread.currentThread().getName() + " :" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.equals("t1")) {
            increase();
        } else {
            printCount();
        }
    }    
}
