package org.frank.java.thread.wait.demo01;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer is producing.");
                try {
                    lock.wait(); // 等待通知
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer resumed.");
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Consumer is waiting.");
                lock.notify(); // 发送通知给等待的线程
                System.out.println("Consumer received notification.");
            }
        });

        producer.start();
        consumer.start();
    }
}
