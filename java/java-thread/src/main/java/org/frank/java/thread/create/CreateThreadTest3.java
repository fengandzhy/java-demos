package org.frank.java.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThreadTest3 {
    
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }
}
