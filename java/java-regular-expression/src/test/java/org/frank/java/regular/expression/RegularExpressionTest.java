package org.frank.java.regular.expression;

import org.junit.Assert;
import org.junit.Test;




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

    }
//
//    /**
//     * windows 后面要跟至少一个字符(.{1,}), 这些字符必须是95,98,NT,2000里面任意选一个
//     * */
//    @Test
//    public void test3(){
//        String reg3 = "windows(?=95|98|NT|2000).{2}";
//        String str3 = "windows95";
//        //Assert.assertTrue(str3.matches(reg3));
//        System.out.println(str3.matches(reg3));
//    }
//
//    @Test
//    public void test4(){
//        String reg4 = "sin(?=M\\.).{2}";
//        String str4 = "sinM.";
//        System.out.println(str4.matches(reg4));
//    }
//
//
//    /**
//     * re 后面要跟至少一个字符(.{1,}), 这些字符必须是gular,所以这里是false
//     * */
//    @Test
//    public void test5(){
//        String reg5 = "re(?=gular).{1,}";
//        String str5 = "reg"; //false
//        System.out.println(str5.matches(reg5));
//    }
//
//    /**
//     * ^$ 这个不用说了，正则的定界符和匹配字符串的开始(^)和结束($)
//     * .{6,}，这个也好懂，那个点儿（.）代表任意的字符，只要至少有6位就OK
//     * .*\d 必须有一个数字, .*[a-zA-Z] 必须要有一个字母
//     * (?=.*\d)的意思是，有一个东西，它的后面必须匹配.*\d
//     * 同理 (?=.*[a-zA-Z]) 有一个东西，它的后面必须要匹配 .*[a-zA-Z]
//     * (?=.*\d)(?=.*[a-zA-Z]).{6,} 有一个东西，它后面既要匹配.*[a-zA-Z] 也要匹配.*\d 而且长度不小于6位
//     * */
//    @Test
//    public void test6(){
//        String reg6 = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,}$";
//        String str6 = "1a1bcD";
//        System.out.println(str6.matches(reg6));
//    }
//
//    /**
//     * 后面必须要加.{1,} 否则不行
//     * */
//    @Test
//    public void test7(){
//        String reg7 = "ab(?=[A-Z]).{1,}";
//        String str7 = "abZW863";
//        System.out.println(str7.matches(reg7));
//    }
//
//    /**
//     * 在abc前面必须至少要有一个字符.{1,}而且这个字符必须是数字(?<=\d)
//     * */
//    @Test
//    public void test8(){
//        String reg8 = ".{1,}(?<=\\d)abc";
//        String str8 = "122abc";
//        System.out.println(str8.matches(reg8));
//    }
//
//    @Test
//    public void test9(){
//        String reg9 = ".{1,}(?<=\\d)abc";
//        String str9 = "122abc";
//        System.out.println(str9.matches(reg9));
//        Pattern b = Pattern.compile(".{1,}(?<=\\d)abc");
//        Matcher m = b.matcher(str9);
//        System.out.println(m.matches());
//    }
}
