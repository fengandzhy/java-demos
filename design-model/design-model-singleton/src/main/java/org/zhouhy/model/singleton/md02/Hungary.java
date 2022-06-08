package org.zhouhy.model.singleton.md02;

public class Hungary {
    
    private static Hungary hungry = new Hungary();
    
    private Hungary(){
        
    }
    
    public static Hungary getInstance(){
        return hungry;
    }
}
