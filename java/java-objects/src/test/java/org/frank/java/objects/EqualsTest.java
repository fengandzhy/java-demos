package org.frank.java.objects;

import org.frank.java.objects.entities.Person;
import org.junit.Test;

import java.util.Objects;

/**
 * 1. a.equlas(b); 如果a是null, 则会抛出NullPointerException, 所以用Objects.equals(Object a, Object b) 
 * 
 * */
public class EqualsTest {
    
    @Test
    public void Test1(){        
        System.out.println(Objects.equals(null,"abc"));
        System.out.println(Objects.equals(null,null));
        System.out.println(Objects.equals("abc",null));
    }
    
    @Test
    public void TestPersonEquals(){
        Person p1 = new Person("a",12);
        Person p2 = new Person("a", 12);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}
