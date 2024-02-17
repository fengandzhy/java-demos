package org.frank.java17;

import java.util.Optional;

/**
 * or方法允许在Optional对象为空时提供一个替代的Optional对象。
 * */
public class OptionalOrExample {
    public static void main(String[] args) {
        Optional<String> optionalEmpty = Optional.empty();
        Optional<String> optionalHello = optionalEmpty.or(() -> Optional.of("Hello"));
        System.out.println(optionalHello.get());

        String hello = optionalEmpty.orElse("Hello");
        System.out.println(hello);

        String hello1 = optionalEmpty.orElseGet(() -> "Hello");
        System.out.println(hello1);
    }
}
