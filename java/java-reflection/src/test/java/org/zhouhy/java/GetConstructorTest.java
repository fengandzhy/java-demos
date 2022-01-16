package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Person;
import java.lang.reflect.Constructor;


public class GetConstructorTest {

    @Test(expected = Test.None.class)
    public void getConstructors() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Class personClass = Person.class;

        System.out.println("所有构造方法");
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("空参构造方法");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);

        System.out.println("带参构造方法");
        Constructor constructor2 = personClass.getConstructor(int.class, String.class, long.class, long.class, float.class, int.class);
        System.out.println(constructor2);

        System.out.println("用 getDeclaredConstructors 试试");
        Constructor[] constructors1 = personClass.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }
    }
}
