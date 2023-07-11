package org.frank.java.regular.expression;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

    /**
     * (0-9)表示匹配"0-9"本身，它就是一个字符串和String reg1 = "0-9"; 没有区别
     * (0,9) 表示匹配"0,9"本身
     * */
    @Test
    public void test1(){
        String reg1 = "(0-9)";
        String str1 = "0-9";
        String str2 = "0"; 
        Assert.assertTrue(str1.matches(reg1));
        Assert.assertFalse(str1.matches(str2));

        String reg3 = "(0,9)";
        String str3 = "0,9";
        Assert.assertTrue(str3.matches(reg3));

        String reg4 = "0,9";
        String str4 = "0,9";
        Assert.assertTrue(str4.matches(reg4));
    }

    /**
     * .	Any character (may or may not match line terminators), 任意字符
     * X?	X, once or not at all       零个或一个
     * X*	X, zero or more times       零个或多个
     * X+	X, one or more times        一个或多个
     * X{n}	X, exactly n times          x出现n次
     * X{n,}	X, at least n times     x出现至少n次
     * X{n,m}	X, at least n but not more than m times 出现n~m次
     * [0,9] 表示就一位，不是0，就是 9
     * [0-9] 表示就一位，从0到9 
     * 
     * 
     */    
    @Test
    public void test2(){
        Assert.assertTrue("a".matches("."));
        Assert.assertTrue("aa".matches("aa"));
        
        Assert.assertTrue("aaaa".matches("a*"));
        Assert.assertTrue("".matches("a*"));
        
        Assert.assertTrue("aaaa".matches("a+"));
        Assert.assertTrue("a".matches("a+"));
        Assert.assertFalse("".matches("a+"));
        
        Assert.assertTrue("a".matches("a?"));
        Assert.assertTrue("".matches("a?"));
        Assert.assertFalse("aa".matches("a?"));
        Assert.assertFalse("do".matches("do(es)?")); // do后面跟着1次或者0次的es
        Assert.assertFalse("does".matches("do(es)?"));

        // \d	A digit: [0-9], 表示数字, 但是在java中对"\"这个符号需要使用\进行转义, 所以出现\\d
        Assert.assertTrue("2345".matches("\\d{2,5}"));
        // \\.用于匹配"."
        Assert.assertTrue("192.168.0.123".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        // [0-2]指必须是0~2中的一个数字
        Assert.assertTrue("192".matches("[0-2][0-9][0-9]"));
        Assert.assertTrue("192".matches("[0-9]{2,3}"));
        Assert.assertFalse("192".matches("[0-9]{4}")); // 0到9 的数字有4位
        
        Assert.assertTrue("0".matches("[0,9]")); // 不是0就是9 
        Assert.assertTrue("9".matches("[0,9]"));
        Assert.assertFalse("8".matches("[0,9]"));
        Assert.assertTrue("090".matches("[0,9]{2,3}")); // 不是9就是0的数字有两到三位
    }

    /**
     * [] 括起来的都是一位字符 [^abc] 表示这里只有一位字符, 这个字符是除 abc之外的所有字符
     * */
    @Test
    public void test3(){
        //[abc]指abc中的其中一个字母
        Assert.assertTrue("a".matches("[abc]"));
        //[^abc]指除了abc之外的字符
        Assert.assertTrue("1".matches("[^abc]"));
        Assert.assertFalse("1".matches("[^abc|1]")); // 除了abc以及1以外的所有字符都能匹配
        //a~z或A~Z的字符, 以下三个均是或的写法
        Assert.assertTrue("A".matches("[a-zA-Z]"));
        Assert.assertTrue("A".matches("[a-z|A-Z]"));
        Assert.assertTrue("A".matches("[a-z[A-Z]]"));
        //[A-Z&&[REQ]]指A~Z中并且属于REQ其中之一的字符
        Assert.assertTrue("R".matches("[A-Z&&[REQ]]"));        
    }

    /**
     * \d	A digit: [0-9]          数字
     * \D	A non-digit: [^0-9]     非数字
     * \s	A whitespace character: [ \t\n\x0B\f\r] 空格
     * \S	A non-whitespace character: [^\s]       非空格
     * \w	A word character: [a-zA-Z_0-9]          数字字母和下划线
     * \W	A non-word character: [^\w]             非数字字母和下划线
     * 在String 中表达转义符\ 用的是\\, 
     * 在正则表达式中要表达转义符用的是\\\\  前面两个\\ 表达转移符 \ 后面两个\\ 表达 \ 本身
     * 
     * 
     * */
    @Test
    public void test4(){
        // \\s{4}表示4个空白符 \\s 表示空白符, 默认是一个字符, 加上{4} 就表示有4个
        Assert.assertTrue(" \n\r\t".matches("\\s{4}"));
        Assert.assertTrue("\n\r\t".matches("\\s{3}")); // 注意和上面相比少了第一个空格
        
        
        // \\S表示非空白符
        Assert.assertTrue("a".matches("\\S"));
        // \\w{3}表示数字字母和下划线
        Assert.assertTrue("a_8".matches("\\w{3}"));
        
        //[a-z]{1,3}字母有1到3个, \\d+ 数字有至少一个  [%^&*]+ %^&* 这些字符至少有一个  
        Assert.assertTrue("abc888&^%".matches("[a-z]{1,3}\\d+[%^&*]+"));
        // 匹配 \
        Assert.assertTrue("\\".matches("\\\\")); // 在正则表达式中//// 表示 /, 正常的 

        Assert.assertFalse("a".matches("aa"));
        Assert.assertTrue("aa".matches("aa"));
        
        //[.-] 表示. 或者 -, 这里的 点. 并不是代表 任意字符 
        Assert.assertTrue(".".matches("[.-]")); 
        Assert.assertTrue("-".matches("[.-]"));
        Assert.assertFalse("e".matches("[.-]"));

        // [\w[.-]] 有一个字符, 它可以是数字字母和下划线 以及 . 和 - 
        //[\w[.-]]+ 有多个上述这样的字符
        Assert.assertTrue(".".matches("[\\w[.-]]+"));
        Assert.assertTrue("dd.-aa".matches("[\\w[.-]]+"));
        Assert.assertTrue(".-aa".matches("[\\w[.-]]+"));

        // [0-9a-zA-Z][\w[.-]]+第一个字符必须是数字或者字母, 后面跟着多个或者一个上述描述的字符(数字字母和下划线 以及 . 和 -) [\w[.-]]
        // [] 表示一个字符, 例如[\w[.-]] 它就表示一个数字字母和下划线 以及 . 和 -的字符,
        // 而中括号[] 后面的量词 例如 +*{m,n}等,表示对这类字符的数量描述, [\w[.-]]+ 这类字符有一个或者多个 
        Assert.assertFalse(".-aa".matches("[0-9a-zA-Z][\\w[.-]]+"));
        Assert.assertTrue("b.-aa".matches("[0-9a-zA-Z][\\w[.-]]+"));
    }

    /**
     * 分支校验 | 
     * [1-9]\d*\.?\d{1,2}|-[1-9]\d*\.?\d{1,2}|[0]\.\d{1,2}|-[0]\.\d{1,2} 这里有四个分支 分别是 
     * [1-9]\d*\.?\d{1,2}
     * -[1-9]\d*\.?\d{1,2} 
     * [0]\.\d{1,2} 
     * -[0]\.\d{1,2} 
     * 所写出来的式子只要满足以上四个任意一个就可以     
     * */
    @Test
    public void test5(){
        String regex1 = "-?([1-9]+|0)\\d*";
        String str1 = "-03";
        String str5 = "-003";
        Assert.assertTrue(str1.matches(regex1));
        Assert.assertTrue(str5.matches(regex1));
        
        
        String regex2 = "^-?[1-9]\\d*|0?$"; 
        String str2 = "-3";
        String str3 = "3";
        String str4 = "0";        
        Assert.assertTrue(str2.matches(regex2));
        Assert.assertTrue(str3.matches(regex2));
        Assert.assertTrue(str4.matches(regex2));
        
        String regex3 = "z|food";
        String str7 = "z";
        String str6 = "food";
        Assert.assertTrue(str7.matches(regex3));
        Assert.assertTrue(str6.matches(regex3));

        String regex4 = "(z|f)ood";
        String str8 = "zood";
        String str9 = "food";
        Assert.assertTrue(str8.matches(regex4));
        Assert.assertTrue(str9.matches(regex4));

        
        String regex5 = "[1-9]\\d*\\.?\\d{1,2}|-[1-9]\\d*\\.?\\d{1,2}|[0]\\.\\d{1,2}|-[0]\\.\\d{1,2}|0";
        String str10 = "0.3";
        String str11 = "-0.33";
        String str12 = "-.33";
        String str13 = "-1222.33";
        String str14 = "-03";
        String str15 = "0000";
        String str16 = "0";
        String str17 = "-0";
        Assert.assertTrue(str10.matches(regex5));
        Assert.assertTrue(str11.matches(regex5));
        Assert.assertFalse(str12.matches(regex5));
        Assert.assertTrue(str13.matches(regex5));
        Assert.assertFalse(str14.matches(regex5));
        Assert.assertFalse(str15.matches(regex5));
        Assert.assertTrue(str16.matches(regex5));
        Assert.assertFalse(str17.matches(regex5));
    }

    /**
     * 分支校验 | 
     * ([1-9]\d*|-[1-9]\d*)\.?\d{1,2}|([0]|-[0])\.\d{1,2} 这里有两个分支 分别是 
     * ([1-9]\d*|-[1-9]\d*)\.?\d{1,2}
     * ([0]|-[0])\.\d{1,2}     
     * 所写出来的式子只要满足以上两个任意一个就可以
     * 
     * 以([1-9]\d*|-[1-9]\d*)\.?\d{1,2} 为例, 首先要满足括号里面的 ([1-9]\d*|-[1-9]\d*) 同时还要满足\.?\d{1,2} 
     * 但对于满足括号里面的式子来说 满足以下两个之一即可
     * [1-9]\d*
     * -[1-9]\d*
     * 
     *   
     * */
    @Test
    public void test6(){
        String regex6 = "([1-9]\\d*|-[1-9]\\d*)\\.?\\d{1,2}|([0]|-[0])\\.\\d{1,2}|0";
        String str16 = "0.3";
        String str17 = "-0.33";
        String str18 = "-.33";
        String str19 = "-1222.33";
        String str20 = "-03";
        String str21 = "0000";
        String str22 = "0";
        String str23 = "-0";
        
        Assert.assertTrue(str16.matches(regex6));
        Assert.assertTrue(str17.matches(regex6));
        Assert.assertFalse(str18.matches(regex6));
        Assert.assertTrue(str19.matches(regex6));
        Assert.assertFalse(str20.matches(regex6));
        Assert.assertFalse(str21.matches(regex6));
        Assert.assertTrue(str22.matches(regex6));
        Assert.assertFalse(str23.matches(regex6));
    }

    /**
     * Windows(?=95|98|NT|2000) 只有2000 98 95 这三个字符串之前的 Windows字符串 才能被匹配 
     * 
     * Windows(?=95|98|NT|2000).*  需要这么看 Windows.* Windows后面跟着0个或多个字符, 但是 这个Windows 必须是在 2000 98 95 这三个字符串之前
     * 
     * */
    @Test
    public void test7(){
        String reg1 = "Windows(?=95|98|NT|2000)"; // 
        Pattern r = Pattern.compile(reg1);
        String str1 = "Windows2000";
        String str2 = "Windows2001";
        Matcher m = r.matcher(str1);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );            
        } else {
            System.out.println("NO MATCH");
        }

         m = r.matcher(str2);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }

        String reg2 = "Windows(?=95|98|NT|2000).*";
        String str3 = "Windows2000abcd";
        String str4 = "Windows98ddss";
        String str5 = "Windows97ddss";
        Assert.assertTrue(str3.matches(reg2));
        Assert.assertTrue(str4.matches(reg2));
        Assert.assertFalse(str5.matches(reg2));
    }

    /**
     * windows(?=95|98|NT|2000).{2}
     * windows 后面要跟两个字符.{2}, 这些字符必须是95,98,NT,2000里面任意选一个
     * 2000 是四个字符, 所以 windows2000 匹配不上
     * (?=.*[0-9]) .* 表示任意字符, 零个或者多个, [0-9]这是一个数字, 那么连起来就是 必须要有数字
     * (?=.*[A-z]) 那就表示必须包含字母
     * (?=.*[\x21-\x2f]) 表示必须包含特殊字符
     * [A-z0-9\x21-\x2f]{6,16} 字母, 数字, 特殊字符的组合长度为6到16位 但是这个组合必须先满足 (?=.*[0-9])(?=.*[A-z])(?=.*[\x21-\x2f]) 这些预判断
     * 
     * sin(?=M\.).{2} 表示sin 后面必须跟两个字符 .{2}, (?=M\.) 对这两个字符做了限定, 必须是 M. (?=M\.) 正向肯定检查, sin.{2} 做了一个限制
     * 
     * 
     * 
     * */
    @Test
    public void test8(){
        String reg = "windows(?=95|98|NT|2000).{2}";
        String str1 = "windows98";
        String str2 = "windows2000";
        Assert.assertTrue(str1.matches(reg));
        Assert.assertFalse(str2.matches(reg));

        String reg1 = "windows(?=95|98|NT|2000)"; // 没有量词
        Assert.assertFalse(str1.matches(reg1));
        Assert.assertFalse(str2.matches(reg1));

        String reg2 = "^(?=.*[0-9])(?=.*[A-z])(?=.*[\\x21-\\x2f])[A-z0-9\\x21-\\x2f]{6,16}$";
        String str3 = "Xiaoxiong211610&";
        Assert.assertTrue(str3.matches(reg2));        

        String reg3 = "sin(?=M\\.).{2}";
        String str4 = "sinM.";
        Assert.assertTrue(str4.matches(reg3));
    }

    /**
     *  "fiction(?!compiler) 只要不在compiler 前面的fiction 都能匹配
     *  (?<=compiler)fiction 只要在compiler 后面的fiction 都能匹配上
     *  (?<!compiler)fiction 只要不在compiler 后面的fiction 都能匹配上
     * */
    @Test
    public void test9(){
        String reg = "fiction(?!compiler)";
        Pattern r = Pattern.compile(reg);
        String str1 = "compilerfiction";
        Matcher m = r.matcher(str1);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }

        String reg1 = "(?<=compiler)fiction";
        r = Pattern.compile(reg1);        
        m = r.matcher(str1);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }

        String reg2 = "(?<!compiler)fiction";
        r = Pattern.compile(reg2);
        m = r.matcher(str1);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test10(){
        String reg1 = ".{2}(?<=95|98|NT|2000)windows";
        String str1 = "98windows";        
        Assert.assertTrue(str1.matches(reg1));

        String reg2 = "windows.{2}(?<=95|98|NT|2000)";
        String str2 = "windows98";
        Assert.assertTrue(str2.matches(reg2));
    }
}
