package org.frank.java.thread.create;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() {
        return "I am here.";
    }
}
