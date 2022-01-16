package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateInstanceTest {

    @Test(expected = Test.None.class)
    public void getConstructors() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        Person p1 = personClass.newInstance();

        Constructor<Person> constructor1 = personClass.getConstructor();
        Person p2 = constructor1.newInstance();

        Constructor<Person> constructor2 = personClass.getConstructor(int.class, String.class, long.class, long.class, float.class, int.class);
        Person p3 = constructor2.newInstance(20, "村雨遥", 1312020l, 3, 99.0F, 2);
        
        System.out.println(p3);
        System.out.println(p2);
        System.out.println(p1);
    }
}
