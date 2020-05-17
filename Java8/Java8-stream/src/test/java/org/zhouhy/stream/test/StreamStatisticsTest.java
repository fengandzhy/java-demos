package org.zhouhy.stream.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.stream.entity.User;

public class StreamStatisticsTest {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private Stream<User> stream = null;
	
	@Before
	public void setUp() throws Exception {
		Random random = new Random();
		List<User> list = new ArrayList<>();
		for(int i=0;i<5;i++){
			double height = random.nextDouble()*100+100;
			User u = new User(i, height);
			list.add(u);
		}
		stream = list.stream();
	}
	
	@Test
	public void test1() {
		double sum = stream.mapToDouble(User::getHeight).sum();
		System.out.println("身高 总和：" + df.format(sum));
	}
	
	@Test
	public void test2() {
		double max = stream.mapToDouble(User::getHeight).max().getAsDouble();
		System.out.println("最大身高：" + df.format(max));
	}
	
	@Test
	public void test3() {
		double min = stream.mapToDouble(User::getHeight).min().getAsDouble();
		System.out.println("最小身高：" + df.format(min));
	}
	
	@Test
	public void test4() {
		double ave = stream.mapToDouble(User::getHeight).average().getAsDouble();
		System.out.println("平均身高：" + df.format(ave));
	}
}
