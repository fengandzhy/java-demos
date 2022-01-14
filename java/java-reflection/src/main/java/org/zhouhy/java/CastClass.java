package org.zhouhy.java;

public class CastClass {
    
    public static <T> T get(Class<T> clazz, Object o){
        if(clazz.isInstance(o)){
            return clazz.cast(o);
        }
        return null;
    }
}
