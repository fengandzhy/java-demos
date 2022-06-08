package org.zhouhy.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class OutClassTest {
    
    @Test
    public void testReflectInnerTest(){
        OutClass entity = new OutClass();
        Class<?>[] declaredClasses = OutClass.class.getDeclaredClasses();
        Arrays.stream(declaredClasses).forEach(clazz->{
            Arrays.stream(clazz.getDeclaredMethods()).forEach(method -> {
                try {
                    method.setAccessible(true);
                    // 获取内部类的构造方法，内部类的构造只能通过外部类来获取
                    Constructor declaredConstructor = clazz.getDeclaredConstructor(OutClass.class);
                    declaredConstructor.setAccessible(true);
                    // 由外部类对象来反射获取内部类的对象
                    Object obj = declaredConstructor.newInstance(entity);
                    method.invoke(obj);
                } catch (IllegalAccessException | NoSuchMethodException
                        | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
