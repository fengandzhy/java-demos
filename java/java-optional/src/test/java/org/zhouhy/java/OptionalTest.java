package org.zhouhy.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.java.domain.Address;
import org.zhouhy.java.domain.Country;
import org.zhouhy.java.domain.User;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {
    
    private static final Logger logger = LoggerFactory.getLogger(OptionalTest.class);
    
    
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

    @Test
    public void whenCheckIfPresent_thenConsume() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        userOptional.ifPresent(u->System.out.println(u.getEmail()));
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        assertFalse(userOptional.isPresent());
        
        User result = userOptional.orElse(user2);
        assertEquals(result.getEmail(),user2.getEmail());
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {    
        User user = new User("john@gmail.com", "1234");    
        logger.info("Using orElse");    
        User result = Optional.ofNullable(user).orElse(createNewUser());    
        logger.info("Using orElseGet");    
        User result2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());
    }
    
    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(u -> u.getEmail()).orElse("default@gmail.com");

        assertEquals(email, user.getEmail());
    }

    @Test
    public void whenFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user)
                .flatMap(u -> u.getPosition()).orElse("default");

        assertEquals(position, user.getPosition().get());
    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));
        assertTrue(result.isPresent());
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User("anna@gmail.com", "1234");

        String result = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");

        assertEquals(result, "default");
    }

    private User createNewUser() {
        logger.info("Creating New User");
        return new User("extra@gmail.com", "1234");
    }
}
