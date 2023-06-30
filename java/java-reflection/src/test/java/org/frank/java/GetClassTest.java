package org.frank.java;

import org.junit.Test;
import org.frank.java.domain.AbstractCar;
import org.frank.java.domain.Car;
import org.frank.java.domain.ICar;
import org.frank.java.domain.Person;

import static org.junit.Assert.assertTrue;

public class GetClassTest {
    
    @Test
    public void getClassTest() throws ClassNotFoundException {
        // 第一种方式，Class.forName("全类名")
        Class class1 = Class.forName("org.frank.java.domain.Person");
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
        Class[] class3 = carClass.getInterfaces();
        while(carClass != null){
            System.out.println(carClass);
            carClass = carClass.getSuperclass();            
        }

        Class class1 = Class.forName("org.frank.java.domain.ICar");
        System.out.println(class1);

        Class class2 = ICar.class;
        System.out.println(class2);
        
        System.out.println(class1 == class3[0]);
    }

    @Test
    public void getInterfaceClassTest() throws ClassNotFoundException {
        Class carClass = AbstractCar.class;
        Class[] class3 = carClass.getInterfaces();        

        Class class1 = Class.forName("org.frank.java.domain.ICar");
        System.out.println(class1);
        Class class2 = ICar.class;
        System.out.println(class2);

        System.out.println(class1 == class3[0]);
    }
}
