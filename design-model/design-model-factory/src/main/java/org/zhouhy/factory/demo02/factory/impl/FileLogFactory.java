package org.zhouhy.factory.demo02.factory.impl;

import org.zhouhy.factory.demo02.log.impl.FileLog;
import org.zhouhy.factory.demo02.factory.LogFactory;
import org.zhouhy.factory.demo02.log.Log;

public class FileLogFactory implements LogFactory {
    
    /**
     * 具体的创建FileLog的逻辑
     * */
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
