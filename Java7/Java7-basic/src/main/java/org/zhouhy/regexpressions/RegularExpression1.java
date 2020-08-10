package org.zhouhy.regexpressions;


/**
 * 正则表达式解读
 * (ab){1,2}
 *
 *
 *
 * */
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

        String reg4 = "^(?=[a]+\\d).{1,}";
        String str4 = "a3wwww";

        System.out.println(str4.matches(reg4));

        String reg5 = "(?=[ab]+\\d).{1,2}a";
        String str5 = "b3a";

        System.out.println(str5.matches(reg5));


        String reg6 = "(?=[a]+).{1,2}";
        String str6 = "aa";

        System.out.println(str6.matches(reg6));

        String reg7 = "industr(?:y|ies)";
        String str7 = "industry";

        System.out.println(str7.matches(reg7));

        String reg8 = "(?=(ab)).{1,2}";
        String str8 = "ab";

        System.out.println(str8.matches(reg8));


        String reg9 = "(ab).{1,2}";
        String str9 = "abcd";

        System.out.println(str9.matches(reg9));

        String reg10 = "(?=.*?[A-Z].+).{1,4}";
        String str10 = "aaBd";

        System.out.println(str10.matches(reg10));

        String reg11 = "(?=A+[A-Z]).{1,12}";
        String str11 = "ABwwwwwwww";

        System.out.println(str11.matches(reg11));
    }
}
