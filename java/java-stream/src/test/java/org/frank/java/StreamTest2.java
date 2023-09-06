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
        listStream.forEach(System.out::println);
        
        Integer[] intArray = new Integer[]{1,2};
        Stream<Integer> arrayStream = Arrays.stream(intArray);
        arrayStream.forEach(System.out::println);

        int[] nums = new int[]{1,2};
        IntStream intStream = IntStream.of(nums);
        intStream.forEach(System.out::println);

        Stream<Integer> IntegerStream = Stream.iterate(0, (x) -> x + 3).limit(4);
        IntegerStream.forEach(System.out::println);

        Stream<Double> DoubleStream = Stream.generate(Math::random).limit(3);
        DoubleStream.forEach(System.out::println);
    }
}
