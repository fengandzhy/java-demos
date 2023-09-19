package org.frank.basic.str.demo01;

public class StringEquals {

    public static void main(String[] args) {
        String s5 = "hello";
        String s6 = "he"+"llo";
        System.out.println(s5==s6);   //true

        String s11 = "a";
        String s22 = "bc";
        String s1 = "abc";
        s6 = s11 + s22;
        String s7 = "a" + "bc";
        System.out.println(s1==s6); //false
        System.out.println(s1==s7); // true
    }
}
