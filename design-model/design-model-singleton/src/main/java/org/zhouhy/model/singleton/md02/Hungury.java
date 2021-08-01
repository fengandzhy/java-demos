package org.zhouhy.model.singleton.md02;

public class Hungury {
    
    private static Hungury hungury = new Hungury();
    
    private Hungury(){
        
    }
    
    public static Hungury getInstance(){
        return hungury;
    }
}
