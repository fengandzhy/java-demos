package org.zhouhy.stream.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamReduceTest {

	private Stream<Integer> stream = null;
	private Stream<String> strStream = null;
	
	@Before
	public void setUp() throws Exception {
		stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		strStream = Arrays.stream(new String[]{"a", "b", "c", "d", "e"});
	}

	@Test
	public void test1() {
		Integer result = stream.reduce(0,Integer::sum);
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
	public void test5() {
		stream.reduce((i,j)->i<j?j:i).ifPresent(System.out::println);
	}
	
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
	
	

}
