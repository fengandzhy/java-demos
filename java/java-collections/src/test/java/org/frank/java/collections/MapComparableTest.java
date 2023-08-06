package org.frank.java.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapComparableTest {
    
    private HashMap<Integer,String> courseMap;
    
    @Before
    public void setUP(){
        this.courseMap = new HashMap<>();
        courseMap.put(1,"C");
        courseMap.put(2,"C++");
        courseMap.put(3,"Java");
        courseMap.put(4,"Spring Framework");
        courseMap.put(5,"Hibernate");
    }
    
    @Test
    public void IteratorTest1(){
        Iterator<Map.Entry<Integer,String>> iterator = courseMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void IteratorTest2(){
        Iterator<Integer> iterator = courseMap.keySet().iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            System.out.print(key+":");
            System.out.println(courseMap.get(key));
        }
    }

    @Test
    public void IteratorTest3(){
        for(Map.Entry<Integer,String> entry:courseMap.entrySet()){
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
        }        
    }

    @Test
    public void IteratorTest4(){
        courseMap.forEach((key,value)->{
            System.out.print(key+":");
            System.out.println(value);
        });
    }

    @Test
    public void IteratorTest5(){
        courseMap.entrySet().stream().forEach(entry->{
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
        });
    }
}
