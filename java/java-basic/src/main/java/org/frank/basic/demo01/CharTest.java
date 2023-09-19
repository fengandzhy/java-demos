package org.frank.basic.demo01;

public class CharTest {
    public static void main(String[] args) {
        char c = ' ';
        System.out.println(isLetterOrDigit(c));
        System.out.println(toLowerCase('A'));
        System.out.println(toUpperCase('b'));
        System.out.println(compare('a','b'));
    }
    
    /**
     * 判断是否是字母还是数字
     * */
    public static boolean isLetterOrDigit(char c){
        return Character.isLetterOrDigit(c);
    }
    
    /**
     * 转成小写
     * */
    public static char toLowerCase(char c){
        return Character.toLowerCase(c);
    }
    
    /**
     * 转成大写
     * */
    public static char toUpperCase(char c){
        return Character.toUpperCase(c);        
    }
    
    /**
     * 可以直接比大小
     * */
    public static int compare(char c1, char c2){
        return Character.compare(c1, c2);
    }
}
