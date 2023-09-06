package org.frank.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
    
    /**
     * 关于stream的创建 3种方式
     * */
    @Test
    public void createSteamTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Stream<Integer> listStream = list.stream();
        
        Integer[] intArray = new Integer[]{1,2};
        Stream<Integer> arrayStream = Arrays.stream(intArray);

        int[] nums = new int[]{1,2};
        IntStream intStream = IntStream.of(nums);
        
    }
}
