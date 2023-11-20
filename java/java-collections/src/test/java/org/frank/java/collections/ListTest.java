package org.frank.java.collections;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    public void removeAllTest(){
        List<Character> characters = new ArrayList<>();
        characters.add('.');
        characters.add('8');
        characters.add('6');
        characters.add('4');
        characters.add('9');
        System.out.println(characters);
        characters.removeAll(characters);
        System.out.println(characters);
    }

    @Test
    public void removeDistinctTest1(){
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
        }};
        System.out.println("原集合:" + list);
        List<Integer> newList = new ArrayList<>();
        list.forEach(i ->{
            if(!newList.contains(i)){
                newList.add(i);
            }
        });
        System.out.println("新集合:" + newList);
    }

    @Test
    public void removeDistinctTest2(){
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
        }};
        System.out.println("原集合:" + list);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer item = iterator.next();
            if(list.indexOf(item) != list.lastIndexOf(item)){
                iterator.remove();
            }
        }
        System.out.println("新集合:" + list);
    }

    /**
     * 这里的HashSet会对原集合重新排序
     * */
    @Test
    public void removeDistinctTest3(){
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
            add(9);
            add(8);
        }};
        System.out.println("原集合:" + list);
        Set<Integer> set = new HashSet(list);        
        System.out.println("新集合:" + set);
    }

    /**
     * 这里的LinkedHashSet不会动原集合的顺序
     * */
    @Test
    public void removeDistinctTest4(){
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
        }};
        System.out.println("原集合:" + list);
        Set<Integer> set = new LinkedHashSet(list);
        System.out.println("新集合:" + set);
    }
}
