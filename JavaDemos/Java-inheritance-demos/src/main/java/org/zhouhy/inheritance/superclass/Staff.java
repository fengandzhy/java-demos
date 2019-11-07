package org.zhouhy.inheritance.superclass;

public class Staff {
	
	/**
	 * 这里变成protected,只能在子类里面调用，不能在unit test里面调用
	 * 这里如果是private,连子类里都无法调用了，只能在自身类里面调用
	 * */
	protected void say() {
		System.out.println("Hello");
	}	
}
