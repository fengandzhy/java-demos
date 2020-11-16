package org.zhouhy.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    
    
    @Test
    public void test1(){
        Map<String,Integer> headers = new HashMap<String,Integer>();
        for(int i=0;i<10;i++){
            headers.put("num",i);
        }
        System.out.println(headers.size());
    }
}
