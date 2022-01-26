package org.zhouhy.factory.demo02.log.impl;

import org.zhouhy.factory.demo02.log.Log;

public class DataBaseLog implements Log {
    
    /**
     * 具体产品的具体业务
     * */
    @Override
    public void writeLog(String destination) {
        System.out.println("DataBaseLog write log to "+destination);
    }
}
