package org.zhouhy.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.java.domain.*;

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
    public void whenCreateOfNullableEmptyOptional_thenNoException(){
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);        
    }

    @Test(expected = Test.None.class)
    public void whenCreateOfNullableSubClassOptional_thenNoException(){
        Student stu = new Student();
        Optional<Student> opt1 = Optional.ofNullable(stu);
        Optional<Person> opt2 = Optional.ofNullable(stu);
        Optional<? extends Person> opt3 = this.getSomePerson();
        Optional<Student> opt4 = this.getSomeStudent();
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("John",opt.get());
    }

    @Test(expected = NoSuchElementException.class) 
    public void whenGetFromOptional_thenNoSuchElementException() {
        String name =null;
        Optional<String> opt = Optional.ofNullable(name);
        opt.get();
    }

    @Test
    public void whenCheckIsPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        assertTrue(userOptional.isPresent());
        assertEquals(userOptional.get().getEmail(),user.getEmail());        
    }

    @Test
    public void whenCheckIfPresent_thenConsume() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        userOptional.ifPresent(u->System.out.println("The email is "+u.getEmail()));
    }

    @Test
    public void whenCheckIfPresent_thenNotConsume() {        
        Optional<User> userOptional = Optional.ofNullable(null);
        userOptional.ifPresent(u->System.out.println("The email is "+u.getEmail()));
    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user2 = new User("john@gmail.com", "1234");
        Optional<User> userOptional = Optional.ofNullable(user);
        assertFalse(userOptional.isPresent());
        
        User u1 = userOptional.orElse(user2);
        assertEquals(u1.getEmail(),user2.getEmail());

        User u2 = userOptional.orElseGet(()->createNewUser());
        assertEquals(u2.getEmail(),"extra@gmail.com");
    }

    @Test(expected = RuntimeException.class)
    public void whenEmptyValue_thenThrowException() {
        User user = null;        
        Optional<User> userOptional = Optional.ofNullable(user);
        assertFalse(userOptional.isPresent());
        userOptional.orElseThrow(()-> new RuntimeException("没有加载到相关数据"));        
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {    
        User user = new User("john@gmail.com", "1234");    
        logger.info("Using orElse");    
        User u1 = Optional.ofNullable(user).orElse(createNewUser());    
        logger.info("Using orElseGet");    
        User u2 = Optional.ofNullable(user).orElseGet(() -> createNewUser());        
    }
    
    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<String> emailOptional = Optional.ofNullable(user)
                .map(u -> u.getEmail());
        String email = emailOptional.orElse("default@gmail.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    public void whenFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        Optional <Optional<String>> opt1 = Optional.ofNullable(user)
                .map(u -> u.getPosition());
        Optional<String> opt2 = Optional.ofNullable(user)
                .flatMap(u->u.getPosition());        
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
    
    private Optional<? extends Person> getSomePerson(){
        return Optional.ofNullable(new Person());
    }

    private Optional<Student> getSomeStudent(){
        return Optional.ofNullable(new Student());
    }
}
