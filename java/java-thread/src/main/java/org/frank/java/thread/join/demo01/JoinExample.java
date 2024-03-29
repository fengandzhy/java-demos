package org.frank.java.thread.join.demo01;

public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join(); // 等待thread1完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
