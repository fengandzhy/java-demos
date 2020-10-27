package org.zhouhy.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {


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
        Pattern pattern1 = Pattern.compile("(a.*?b)");
        Matcher matcher1=pattern1.matcher("aacbacb");

        //System.out.println(matcher1.matches());
        while(matcher1.find()){
            System.out.println(matcher1.group());
        }
        System.out.println(matcher1.matches());

//        Pattern pattern2 = Pattern.compile("(?=.*?[A-Z]).{1,8}");
//        Matcher matcher2=pattern2.matcher("edaaBaa");
//
//        while(matcher2.find()){
//            System.out.println(matcher2.group());
//        }
//
//        Pattern pattern3 = Pattern.compile("Aaa(?=[a]+\\d)");
//        Matcher matcher3=pattern3.matcher("Aaaaa3");
//
//        while(matcher3.find()){
//            System.out.println(matcher3.group());
//        }
    }

}
