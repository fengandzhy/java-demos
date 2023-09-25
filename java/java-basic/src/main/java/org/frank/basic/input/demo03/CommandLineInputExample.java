package org.frank.basic.input.demo03;

public class CommandLineInputExample {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("您输入的参数是: ");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("未提供参数。");
        }
    }
}
