package org.zhouhy.java8.find;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTest {
    
    private List<Integer> list = new ArrayList<>();
    
    @Before
    public void beforeTest(){
        list = Arrays.asList(7,6,9,3,8,2,1);
    }
    
    @Test
    public void filterTest(){
        list.stream().filter(x->x>6).forEach(System.out::println);
    }
}
