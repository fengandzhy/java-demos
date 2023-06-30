package org.frank.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.frank.java.domain.Person;
import org.frank.java.domain.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
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

    @Test (expected = Test.None.class)
    public void getFieldsByGetDeclaredFields() throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
        Class<? extends Person> stuClass = Student.class;

        Field[] personFields = personClass.getDeclaredFields();
        for (Field field : personFields) {
            System.out.println(field);
        }
        
        System.out.println("************************************************");
        
        Field[] studentFields = stuClass.getDeclaredFields();
        for (Field field : studentFields) {
            System.out.println(field);
        }        
    }

    @Test (expected = Test.None.class)
    public void getSuperClassFieldsFromSubClass() throws NoSuchFieldException, IllegalAccessException {
        List<Field> fieldList = new ArrayList<>() ;
        Class<?> tempClass = Student.class;
        while(tempClass != null){
            Field[] fields = tempClass.getDeclaredFields();
            fieldList.addAll(Arrays.asList(fields));
            tempClass = tempClass.getSuperclass();
            System.out.println(tempClass);
        }

        for (Field f : fieldList) {
            System.out.println(f.getName());
        }        
    }

    @Test (expected = Test.None.class)
    public void setPrivateFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field field = personClass.getDeclaredField("name");
        field.setAccessible(true);
        Person p = new Person();
        field.set(p,"name");
        System.out.println(p.getName());
    }

    @Test (expected = Test.None.class)
    public void getAllFieldsInfo() {
        Class<Person> personClass = Person.class;
        Field[] personFields = personClass.getDeclaredFields();
        for (Field field : personFields) {
            Class fieldType = field.getType();
            String typeName = fieldType.getSimpleName();
            
            System.out.println(Modifier.toString(field.getModifiers())
                    +" "+typeName+" "+field.getName());
        }
    }
}
