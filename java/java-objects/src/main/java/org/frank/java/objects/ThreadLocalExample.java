package org.frank.java.objects;

public class ThreadLocalExample {

    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        // 主线程设置值
        threadLocalValue.set(99);

        System.out.println("Main Thread: " + threadLocalValue.get());

        // 新线程使用ThreadLocal
        new Thread(() -> {
            try {
                System.out.println("Thread 1 Initial: " + threadLocalValue.get());
                threadLocalValue.set(2);
                System.out.println("Thread 1 Updated: " + threadLocalValue.get());
            } finally {
                threadLocalValue.remove();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Thread 2 Initial: " + threadLocalValue.get());
                threadLocalValue.set(3);
                System.out.println("Thread 2 Updated: " + threadLocalValue.get());
            } finally {
                threadLocalValue.remove();
            }
        }).start();
    }
}
