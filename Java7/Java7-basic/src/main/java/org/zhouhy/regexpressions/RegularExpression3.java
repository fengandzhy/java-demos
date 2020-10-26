package org.zhouhy.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression3 {

    /**
     * .	Any character (may or may not match line terminators), 任意字符
     * X?	X, once or not at all       零个或一个
     * X*	X, zero or more times       零个或多个
     * X+	X, one or more times        一个或多个
     * X{n}	X, exactly n times          x出现n次
     * X{n,}	X, at least n times     x出现至少n次
     * X{n,m}	X, at least n but not more than m times 出现n~m次
     * @param args
     */
    public static void main(String[] args) {
        String reg1 = "(a.?b)";
        String str1 = "ab";
        System.out.println(str1.matches(reg1));

        String reg2 = "(o.*?)";
        String str2 = "oooo";
        System.out.println(str2.matches(reg2));

        String reg3 = "@(([a-zA-z0-9]-*){1,}\\.)";
        String str3 = "@12-.";
        System.out.println(str3.matches(reg3));

        String reg4 = "<.*?>";
        String str4 = "<h1>RUNOOB-菜鸟教程</h1>";
        System.out.println(str4.matches(reg4));


    }
}
