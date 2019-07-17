package com.citi.javatest.integertest;

public class IntegerSyn {

	public static void main(String[] args) throws InterruptedException {
		Integer index =0;
		TestObject a = new TestObject(index);
		synchronized (index) {
			new Thread(a).start();
			index.wait();
		}
		System.out.println("end");
	}
	
	
}
