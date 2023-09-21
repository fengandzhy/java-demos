package org.frank.java.thread.yield.demo01;

public class YieldExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield(); // 提示放弃 CPU 时间片
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield(); // 提示放弃 CPU 时间片
            }
        });

        thread1.start();
        thread2.start();
    }
}
