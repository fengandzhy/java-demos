package org.frank.java.thread.sync.demo04;


@SuppressWarnings("DuplicatedCode")
public class MyThreadSynchronized4 implements Runnable{

    private static int count =0;    
    public synchronized static void increase() {        
        for (int i = 0; i < 3; i++){
            try {
                System.out.println(Thread.currentThread().getName() + " :" + count++);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }          
    }
    @Override
    public  void run() {
        increase();
    }
}
