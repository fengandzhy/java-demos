package org.zhouhy.java.thread.deadlock;

public class DeadLock {
	private static final Object objA = new Object();
	private static final Object objB = new Object();
	
	public static void main(String args[]) {
		new Thread(()->{
			synchronized(objA) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				synchronized(objB) {
					System.out.println("A catch B");
				}
			}
		}).start();
		
		new Thread(()->{
			synchronized(objB) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {					
//					e.printStackTrace();
//				}
				synchronized(objA) {
					System.out.println("B catch A");
				}
			}
		}).start();
	}
}
