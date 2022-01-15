package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Car;
import org.zhouhy.java.domain.Person;
import static org.junit.Assert.assertTrue;

public class GetClassTest {
    
    @Test
    public void getClassTest() throws ClassNotFoundException {
        // 第一种方式，Class.forName("全类名")
        Class class1 = Class.forName("org.zhouhy.java.domain.Person");
        System.out.println(class1);

        // 第二种方式，类名.class
        Class class2 = Person.class;
        System.out.println(class2);

        // 第三种方式，对象.getName()
        Person person = new Person();
        Class class3 = person.getClass();
        System.out.println(class3);
        
        assertTrue(class1 == class2);
        assertTrue(class2 == class1);
    }

    @Test
    public void getSuperClassTest() throws ClassNotFoundException {
        Class carClass = Car.class;
    }
}
