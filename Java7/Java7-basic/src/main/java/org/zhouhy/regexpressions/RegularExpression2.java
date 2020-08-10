package org.zhouhy.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {


    /**
     *
     *
     * */
    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("(a.*?b)");
        Matcher matcher1=pattern1.matcher("aacbacb");

        while(matcher1.find()){
            System.out.println(matcher1.group());
        }

        Pattern pattern2 = Pattern.compile("(?=.*?[A-Z]).{1,8}");
        Matcher matcher2=pattern2.matcher("edaaBaa");

        while(matcher2.find()){
            System.out.println(matcher2.group());
        }

        Pattern pattern3 = Pattern.compile("Aaa(?=[a]+\\d)");
        Matcher matcher3=pattern3.matcher("Aaaaa3");

        while(matcher3.find()){
            System.out.println(matcher3.group());
        }
    }

}
