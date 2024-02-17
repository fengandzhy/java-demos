package org.frank.java17;

import java.util.Optional;

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
