package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Person;

import java.lang.reflect.Field;

public class GetFieldsTest {

    @Test(expected = Test.None.class /* no exception expected */)
    public void getFieldsTest(){
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
    }
}
