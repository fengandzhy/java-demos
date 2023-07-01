package org.frank.java.objects;

import org.frank.java.objects.entities.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    
    /**
     * 1 当只重新equals 方法不重新hashCode 方法时, p1.equals(p2) 为true p1.hashCode() == p2.hashCode() 为false
     * 出现以上问题的原因是，如果只重写了 equals 方法，那么默认情况下，Set 进行去重操作时，会先判断两个对象的 hashCode 是否相同，
     * 此时因为没有重写 hashCode 方法，所以会直接执行 Object 中的 hashCode 方法，而 Object 中的 hashCode 方法对比的是两个
     * 不同引用地址的对象，所以结果是 false，那么 equals 方法就不用执行了，直接返回的结果就是 false：两个对象不是相等的，
     * 于是就在 Set 集合中插入了两个相同的对象。
     * 
     * 2 只有既重写了hashCode 方法和 equlas 方法时 才会让Set 只存一个Person对象.
     * 
     * 3. 如果hashCode 值相等 equlas 也可以不相等
     * */
    @Test
    public void TestPersonEquals(){
        Person p1 = new Person("a",12);
        Person p2 = new Person("a", 12);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
        Set<Person> hashSet = new HashSet<>();
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);
    }
}
