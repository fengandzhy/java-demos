package org.frank.java.asserts;

public class AssertTest {
    public static void main(String[] args) {
        checkName(null);
    }
    
    public static void checkName(String name){
        assert name!=null:"name is empty";
        System.out.println("We are here!");
    }
}
