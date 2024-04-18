package org.frank.java.lambda.entity;

public class MethodReferenceExample {
    public static String combine(String a, String b) {
        return a + b;
    }

    public static String combine(Integer a, Integer b) {
        return String.valueOf(a + b);
    }
}
