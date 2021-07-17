package org.zhouhy.model.singleton.md01;

public class LazySafe {
    private LazySafe(){}

    private static LazySafe lazySafe;

    public static  LazySafe getInstance(){
        if(lazySafe==null){
            //双重判定
            synchronized (LazySafe.class){
                if(lazySafe==null){
                    lazySafe=new LazySafe();
                }
            }
        }
        return lazySafe;
    }
}
