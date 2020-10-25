package org.zhouhy.java8;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.java8.entity.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AppleComparatorTest {

    private List<Apple> appleList;

    @Before
    public void setUp() {
        appleList = new ArrayList<>();
        Apple apple1 = new Apple("red",100);
        Apple apple2 = new Apple("green",120);
        Apple apple3 = new Apple("yellow",130);
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
    }

    @Test
    public void test1(){
        Comparator<Apple> comparator = (a1,a2)->{
            return (int)(a2.getWeight() - a1.getWeight());
        };
        appleList.sort(comparator);
        for(Apple apple:appleList){
            System.out.println(apple.getColor());
        }
    }

}
