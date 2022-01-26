package org.zhouhy.singleton.md02;

public class Hungary {
    
    private static Hungary hungury = new Hungary();
    
    private Hungary(){
        
    }
    
    public static Hungary getInstance(){
        return hungury;
    }
}
