package org.zhouhy.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UsefulUtilsTest {
    
    @Test
    public void testListToString(){
        UsefulUtils.listToString();
    }

    @Test
    public void testEqualsIgnoreCase(){
        assertTrue(UsefulUtils.equalsIgnoreCase("Abc","aBC"));
        assertFalse(UsefulUtils.equalsIgnoreCase("Acb","dBC"));
        
    }

    @Test
    public void testIsEquals(){
        assertTrue(UsefulUtils.isEquals(null,null));
        assertFalse(UsefulUtils.isEquals(null,"dBC"));
        String str = new String("Abc");
        assertTrue(UsefulUtils.isEquals(str,"Abc"));
    }

    @Test
    public void testRetainList(){        
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        listA.add("a");
        listA.add("b");
        listA.add("c");
        
        listB.add("a");
        listB.add("c");
        listB.add("d");
        
        UsefulUtils.retainList(listA,listB);
        System.out.println(listA);
    }

    @Test
    public void testAbbreviate(){
        System.out.println(UsefulUtils.abbreviate("abcdefg",6));
    }
}
