package org.zhouhy.regexpressions;

public class RegularExpression1 {

    public static void main(String[] args) {
        String reg1 = "[z]+";
        String str1 = "zzzz";

        System.out.println(str1.matches(reg1));


        String reg2 = "a.*b";
        String str2 = "aacbacb";

        System.out.println(str2.matches(reg2));


        String reg3 = "a.*?b";
        String str3 = "aacbacb";

        System.out.println(str3.matches(reg3));


    }
}
