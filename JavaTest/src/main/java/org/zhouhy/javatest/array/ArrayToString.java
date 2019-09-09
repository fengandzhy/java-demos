package org.zhouhy.javatest.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToString {

	public static void main(String[] args) {
		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
		System.out.println(Arrays.toString(nums));
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		
		System.out.println(Arrays.deepToString(list.toArray()));
	}

}
