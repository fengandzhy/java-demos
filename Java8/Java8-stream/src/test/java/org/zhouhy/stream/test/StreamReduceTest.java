package org.zhouhy.stream.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.stream.entity.Dish;

public class StreamReduceTest {

	private Stream<Integer> stream = null;
	private Stream<String> strStream = null;
	private Stream<Dish> dishStream = null;
	
	@Before
	public void setUp() throws Exception {
		stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		strStream = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});
		List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
		dishStream = menu.stream();

	}

	/**
	 * 从2起开始累加
	 * */
	@Test
	public void test1() {
		Integer result = stream.reduce(2,Integer::sum);
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		stream.reduce(Integer::sum).ifPresent(System.out::println);		
	}
	
	@Test
	public void test3() {
		stream.reduce(Integer::max).ifPresent(System.out::println);		
	}
	
	@Test
	public void test4() {
		stream.reduce(Integer::min).ifPresent(System.out::println);
	}
	
	@Test
	/**
	 * 找最大值
	 * */
	public void test5() {
		stream.reduce((i,j)->i<j?j:i).ifPresent(System.out::println);
	}
	
	/**
	 * reduce可以作为一种累加器也可以让它成为一种转换器
	 * */
	@Test
	public void test6() {
		String str = strStream.reduce("",(a,b)->{
			if(!"".equals(a)){
				return a + "|" + b;
			}else{
				return b;
			}
		});
		System.out.println(str);
	}
	
	@Test
	/**
	 * 找出卡路里最低的
	 * */
	public void test7() {
		Optional<Dish> oDish = dishStream.reduce((d1,d2)->d1.getCalories()<d2.getCalories()?d1:d2);
		oDish.ifPresent(System.out::println);
	}

}
