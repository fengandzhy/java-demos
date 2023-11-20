package org.frank.java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    
    
}
