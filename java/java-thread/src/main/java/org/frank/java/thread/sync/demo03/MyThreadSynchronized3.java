package org.frank.java.thread.sync.demo03;


@SuppressWarnings("DuplicatedCode")
public class MyThreadSynchronized3 implements Runnable{

    private static int count =0;
    
    @Override
    public synchronized void run() {        
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
