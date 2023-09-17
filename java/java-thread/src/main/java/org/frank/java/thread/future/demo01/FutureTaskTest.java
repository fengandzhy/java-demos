package org.frank.java.thread.future.demo01;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> "Frank");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "Frank");
        System.out.println(future.get());
        executorService.shutdown();
    }
}
