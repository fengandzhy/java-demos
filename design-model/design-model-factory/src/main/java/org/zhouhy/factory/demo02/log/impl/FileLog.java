package org.zhouhy.factory.demo02.log.impl;

import org.zhouhy.factory.demo02.log.Log;

public class FileLog implements Log {
    
    @Override
    public void writeLog(String destination) {
        System.out.println("FileLog write log to "+destination);
    }
}
