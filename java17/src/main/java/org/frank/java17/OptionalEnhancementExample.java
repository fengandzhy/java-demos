package org.frank.java17;

import java.util.Optional;

/**
 * ifPresentOrElse 方法是在Java 9中引入到Optional类的。
 * 这个方法允许你为Optional对象提供两个操作：一个在值存在时执行的操作，另一个在值不存在时执行的操作。
 * */
public class OptionalEnhancementExample {
    public static void main(String[] args) {
        Optional<String> optionalPresent = Optional.of("Hello");
        Optional<String> optionalEmpty = Optional.empty();
        
        optionalPresent.ifPresentOrElse(
                value -> System.out.println("Value is present:"+value),
                () -> System.out.println("Value is not present.")
        );
        
        optionalEmpty.ifPresentOrElse(
                value -> System.out.println("Value is present:"+value),
                () -> System.out.println("Value is not present.")
        );
    }
}
