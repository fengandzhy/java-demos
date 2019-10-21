package org.zhouhy.java.java8.stream.groupby;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class GroupByDemoTest {

	private GroupByDemos groupByDemos;
	
	@Before
	public void init() {
		System.out.println("开始测试");
	}
	
	@Test
	void test1() {
		groupByDemos = new GroupByDemos();
		List<Student> list1= Arrays.asList(
                new Student(1,"one","zhao"),new Student(2,"one","qian"),new Student(3,"two","sun"));
		groupByDemos.groupBy1(list1);
	}
	
	@Test
	void test2() {
		groupByDemos = new GroupByDemos();
		List<Student> list1= Arrays.asList(
                new Student(1,"one","zhao"),new Student(2,"one","qian"),new Student(3,"two","sun"));
		groupByDemos.groupBy2(list1);
	}
	
	@After
	public void destory() {
		System.out.println("开始测试");
	}

}
