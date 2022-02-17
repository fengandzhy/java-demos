package org.zhouhy.basic.demo01;

public class CharTest {
    public static void main(String[] args) {
        char c = ' ';
        System.out.println(isLetterOrDigit(c));
        System.out.println(toLowerCase('A'));
        System.out.println(toUpperCase('b'));
    }
    
    public static boolean isLetterOrDigit(char c){
        return Character.isLetterOrDigit(c);
    }
    
    public static char toLowerCase(char c){
        return Character.toLowerCase(c);
    }
    
    public static char toUpperCase(char c){
        return Character.toUpperCase(c);
    }
}
