package org.zhouhy.stream.test;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamMatchTest {
	
	private Stream<Integer> stream = null;
	
	@Before
	public void setUp() throws Exception {
		stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});		
	}
	
	@Test
	public void test1() {
		boolean matched = stream.allMatch(i->i>10);
		System.out.println(matched);
	}
	
	@Test
	public void test2() {
		boolean matched = stream.anyMatch(i->i>6);
		System.out.println(matched);
	}
	
	@Test
	public void test3() {
		boolean matched = stream.noneMatch(i->i>10);
		System.out.println(matched);
	}
}
