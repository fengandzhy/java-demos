package org.frank.java17;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * stream方法将Optional对象转换为一个（最多含有一个元素的）Stream。
 * */
public class OptionalStreamExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        String result = optional.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining());

        System.out.println(result); // 输出: HELLO
    }
}
