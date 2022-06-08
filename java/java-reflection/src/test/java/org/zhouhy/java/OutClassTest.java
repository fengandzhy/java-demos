package org.zhouhy.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class OutClassTest {

    private static final Logger logger = LoggerFactory.getLogger(OutClassTest.class);
    
    
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
    
    @Test
    public void testGetClass(){
        Class<?>[] declaredClasses = OutClass.class.getDeclaredClasses();
        for(Class clazz : declaredClasses){
            try {
                Constructor declaredConstructor = clazz.getDeclaredConstructor();
                logger.info(declaredConstructor.newInstance().getClass().getSimpleName());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
