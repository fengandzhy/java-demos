package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.Person;
import org.zhouhy.java.domain.Student;

import java.lang.reflect.Field;

public class GetFieldsTest {

    @Test(expected = Test.None.class /* no exception expected */)
    public void getPersonFieldsTest(){
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
    }
    
    @Test (expected = Test.None.class /* no exception expected */)
    public void getStudentFieldsTest(){
        Class<? extends Person> stuClass = Student.class;
        Field[] fields = stuClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
    }

    @Test (expected = NoSuchFieldException.class)
    public void getStudentFieldByFieldName() throws NoSuchFieldException {
        Class<? extends Person> stuClass = Student.class;
        Field field1 = stuClass.getField("id");
        System.out.println(field1);
        Field field2 = stuClass.getField("age");
        System.out.println(field2);
        Field field3 = stuClass.getField("stuNo");
        System.out.println(field3);

        Field field4 = stuClass.getField("rank");
        System.out.println(field4);
    }

    @Test (expected = Test.None.class)
    public void getSetAttributeValueFromField() throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
        Person person = new Person();
        Field idField = personClass.getField("id");
        idField.set(person, 1312120l);
        System.out.println("id：" + idField.get(person));
    }
    
    
}
