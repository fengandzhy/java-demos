package org.frank.java.collections;

import org.junit.Test;
import java.util.Collections;
import java.util.Set;

public class CollectionComparableTest {
    
    @Test
    public void singletonTest(){
        Set set = Collections.singleton(50);
        System.out.println(set);
    }
}
