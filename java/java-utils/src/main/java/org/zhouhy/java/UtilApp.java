package org.zhouhy.java;

/**
 * 1. StringUtils.abbreviateMiddle("12345678910", "***", 5); 这个意思就是, 一共显示5个字符然后中间的用***,
 * 那么剩下的字符从第一个字符和最后一个字符开始取. 例如本例最多显示5个字符其中3个字符是*** 那么还剩两个, 取第一个和最后一个组成1***0
 * 同理StringUtils.abbreviateMiddle("12345678910", "*", 4); 最大显示4个字符, 其中一个是* 还剩下3个, 先取第一个，再取最后一个
 * 还剩一个, 取第二个 最后是12*0
 * 一定要保证显示的字符长度一定要比替代的字符长度多2个以上,
 * StringUtils.abbreviateMiddle("12345678910", "***", 5); 它替代的字符长度是3, 显示的长度是5, 这是可以的. 那如果显示的长度是4
 * 这就不行了
 * 
 * 
 * 
 * */
public class UtilApp {
    public static void main(String[] args) {
        
    }
}
