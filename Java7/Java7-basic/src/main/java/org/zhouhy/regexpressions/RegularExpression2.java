package org.zhouhy.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {


    /**
     * 
     *
     * */
    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("a.*?b");
        Matcher matcher=pattern1.matcher("aacbacb");

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

}
