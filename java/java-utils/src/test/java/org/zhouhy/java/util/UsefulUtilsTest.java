package org.zhouhy.java.util;

import org.junit.Test;
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
    
    
}
