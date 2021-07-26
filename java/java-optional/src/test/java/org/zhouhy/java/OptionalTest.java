package org.zhouhy.java;

import org.junit.Test;
import org.zhouhy.java.domain.User;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("John",opt.get());
    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        assertTrue(userOptional.isPresent());
        assertEquals(userOptional.get().getEmail(),user.getEmail());        
    }
}
