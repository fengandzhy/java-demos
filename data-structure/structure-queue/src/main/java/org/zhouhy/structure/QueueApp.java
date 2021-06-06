package org.zhouhy.structure;

import java.util.Random;

public class QueueApp {
    public static void main(String[] args) {
        SimpleQueue simpleQueue = new SimpleQueue(10);
        Random rand = new Random();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (simpleQueue) {
                while(!simpleQueue.isFull()){
                    int a = rand.nextInt(10);
                    simpleQueue.push(a);
                }
                if(!simpleQueue.isEmpty()){
                    try {
                        simpleQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                simpleQueue.notify();
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (simpleQueue) {
                while(!simpleQueue.isEmpty()){
                    int a = simpleQueue.pop();
                    System.out.println(a +" is pop from the queue!");
                }
                if(!simpleQueue.isFull()){
                    try {
                        simpleQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                simpleQueue.notify();
            }
        }).start();    
    }
}
