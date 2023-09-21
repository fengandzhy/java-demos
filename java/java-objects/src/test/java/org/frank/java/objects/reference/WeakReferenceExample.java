package org.frank.java.objects.reference;

import org.junit.Test;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    
    @Test
    public void weakReferenceTest(){
        String data = "Hello, World!";
        WeakReference<String> weakReference = new WeakReference<>(data);

        // 使用弱引用对象访问被引用的对象
        String result = weakReference.get();
        System.out.println("弱引用对象的内容：" + result);

        // 置空原始对象，这不会影响弱引用对象
        data = null;

        // 强制垃圾回收
        System.gc();

        // 检查弱引用是否还能访问原始对象
        result = weakReference.get();
        if (result == null) {
            System.out.println("弱引用对象不再有效，原始对象已被回收。");
        } else {
            System.out.println("弱引用对象仍然有效，原始对象未被回收。");
        }
    }
}
