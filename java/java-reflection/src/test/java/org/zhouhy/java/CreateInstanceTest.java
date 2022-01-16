package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Person;

import java.lang.reflect.Constructor;

public class CreateInstanceTest {

    @Test(expected = Test.None.class)
    public void getConstructors() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Person p1 = personClass.newInstance();

        Constructor constructor1 = personClass.getConstructor();
        
    }
}
