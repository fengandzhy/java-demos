package org.zhouhy.java8.parallelStream.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * parallelStream，意思就是不止一个线程读取这个list，有可能一个，有可能三个
 * */
public class parallelStreamTest1 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Set<Thread> threadSet = new CopyOnWriteArraySet<>();
		for(int i=0;i<10000;i++) {
			list.add(i);
		}
		//这里不一定有一个线程
		list.parallelStream().forEach(Integer ->{
			Thread thread = Thread.currentThread();
			threadSet.add(thread);
		});
		System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");		
	}

}
