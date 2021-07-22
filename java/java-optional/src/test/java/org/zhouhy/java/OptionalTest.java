package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.User;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {
    
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull(){
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException(){
        User user = null;
        Optional<User> opt = Optional.of(user);
    }

    @Test(expected = Test.None.class)
    public void whenCreateOfNullableEmptyOptional_thenNoException1(){
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);        
    }
}
