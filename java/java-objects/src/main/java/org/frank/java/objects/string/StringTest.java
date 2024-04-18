package org.frank.java.objects.string;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "Java技术堂";
        String str2 = new String("Java") + new String("技术堂");
        System.out.println(str1 == str2.intern());
    }
}
