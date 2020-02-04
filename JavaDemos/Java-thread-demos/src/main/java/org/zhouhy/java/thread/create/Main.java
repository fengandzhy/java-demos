package org.zhouhy.java.thread.create;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Thread1 mTh1=new Thread1("A");
		Thread1 mTh2=new Thread1("B");
		List<Thread> threadList = new ArrayList<>();
		threadList.add(mTh1);
		threadList.add(mTh2);
		
		for(Thread t : threadList) {
			t.start();
		}		
	}
}
