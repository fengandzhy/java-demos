package org.zhouhy.java8.find;

import org.junit.Before;
import org.junit.Test;
import org.zhouhy.java8.entities.Person;

import java.util.*;
import java.util.stream.Collectors;

public class FindTest {
    
    private List<Integer> list = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private List<String> strList = new ArrayList<>();
    private String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
    
    
    @Before
    public void beforeTest(){
        list = Arrays.asList(7,6,9,3,8,2,1);
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        strList = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");        
    }
    
    @Test
    public void filterTest(){
        list.stream().filter(x->x>6).forEach(System.out::println);
    }

    @Test
    public void findFirstTest(){
        Optional<Integer> findFirst = list.stream().filter(x->x>6).findFirst();
        System.out.println("匹配第一个值："+findFirst.get());
    }

    @Test
    public void findAnyTest(){
        Optional<Integer> findAny = list.parallelStream().filter(x->x>6).findFirst();
        System.out.println("匹配任意一个值："+findAny.get());
    }


    @Test
    public void anyMatchTest(){
        boolean anyMatch = list.stream().anyMatch(x->x>6);
        System.out.println("是否存在大于6的值："+anyMatch);
    }

    @Test
    public void findNameTest(){
        List<String> names = personList.stream()
                .filter(x->x.getSalary()>8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("工资大于8000的员工姓名："+names);
    }

    @Test
    public void maxTest(){
        Optional<String> str = strList.stream().max(Comparator.comparing(String::length));
        System.out.println("长度最大的字符串："+str.get());
        
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println("最大的整数："+max.get());

        Optional<String> name = personList.stream().max(Comparator.comparing(Person::getSalary)).map(Person::getName);
        System.out.println("工资最大的员工姓名："+name.get());
    }

    @Test
    public void countTest(){
        long count = list.stream().filter(x->x>6).count();
        System.out.println("大于6的元素个数："+count);
    }

    @Test
    public void mapTest(){
        List<String> strings = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strings);
        
        List<Integer> integers = list.stream().map(x->x+3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + integers);
    }
    
    
}
