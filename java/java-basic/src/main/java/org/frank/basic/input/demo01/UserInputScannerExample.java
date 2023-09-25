package org.frank.basic.input.demo01;

import java.util.Scanner;

public class UserInputScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文本: ");
        String userInput = scanner.nextLine();
        System.out.println("您输入的文本是: " + userInput);
        scanner.close(); // 记得关闭 Scanner 对象
    }   
}
