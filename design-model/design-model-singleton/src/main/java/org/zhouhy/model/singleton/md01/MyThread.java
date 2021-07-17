package org.zhouhy.model.singleton.md01;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(LazySafe.getInstance());        
    }

    public static void main(String args[]) {
        MyThread[] mts = new MyThread[10];
        for(int i=0;i<mts.length;i++) {
            mts[i] = new MyThread();
        }
        for(int i=0;i<mts.length;i++) {
            mts[i].start();
        }
    }
}
