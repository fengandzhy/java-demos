package org.frank.java.objects.reference;

import org.junit.Test;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    
    @Test
    public void softReferenceTest() {
        // 创建一个字符串对象，并创建软引用
        String data = "Hello, World!";
        SoftReference<String> softReference = new SoftReference<>(data);

        // 使用软引用对象访问被引用的对象
        String result = softReference.get();
        System.out.println("软引用对象的内容：" + result);

        // 置空原始对象，这不会影响软引用对象
        data = null;

        // 强制垃圾回收
        System.gc();

        // 检查软引用是否还能访问原始对象
        result = softReference.get();
        if (result == null) {
            System.out.println("软引用对象不再有效，原始对象已被回收。");
        } else {
            System.out.println("软引用对象仍然有效，原始对象未被回收。");
        }
    }
}
