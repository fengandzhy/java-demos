package org.zhouhy.regexpressions;

public class RegularExpression4 {
    public static void main(String[] args) {
        String reg1 = "<.*?>";
        String str1 = "<h1>RUNOOB-AABB</h1>";
        System.out.println(str1.replaceAll(reg1,""));


        String reg2 = "<.*>";
        String str2 = "<h1>RUNOOB-AABB</h1>";
        System.out.println(str2.replaceAll(reg2,""));
    }
}
