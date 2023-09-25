package org.frank.basic.input.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputBufferedReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入文本: ");
        String userInput = reader.readLine();
        System.out.println("您输入的文本是: " + userInput);
        reader.close(); // 记得关闭 BufferedReader 对象
    }
}
