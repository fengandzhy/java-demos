package org.frank.java;

import org.frank.java.domain.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodsTest {

    @Test(expected = Test.None.class)
    public void getMethods() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        System.out.println("获取所有public成员方法,包含父类");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("获取所有成员方法,不包含");
        Method[] methods1 = personClass.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        Method printlnMethod = personClass.getDeclaredMethod("println");
        printlnMethod.setAccessible(true);
        Person person = new Person(20, "村雨遥", 1312020, 3, 99.0F, 2);
        printlnMethod.invoke(person);

        Method getAgeMethod = personClass.getMethod("getAge");
        int age = (int) getAgeMethod.invoke(person);
        System.out.println(age);
        
    }
}
