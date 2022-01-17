package org.zhouhy.model.singleton.md02;

public class Hungary {
    
    private static Hungary hungury = new Hungary();
    
    private Hungary(){
        
    }
    
    public static Hungary getInstance(){
        return hungury;
    }
}
