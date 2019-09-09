package org.zhouhy.javatest.integertest;

import java.util.concurrent.TimeUnit;

public class TestObject implements Runnable{
	
	private Integer index;
	
	public TestObject(Integer index) {
		this.index = index;		
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		synchronized (index) {
			index.notify();
		}
	}
	
	
}
