package org.zhouhy.java.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListAddTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add(2, "c");//这里的int参数必须是<=现有arraylist的长度的
		
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		
	}
}
