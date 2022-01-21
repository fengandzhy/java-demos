package org.zhouhy.design.model.demo02.factory.impl;

import org.zhouhy.design.model.demo02.factory.LogFactory;
import org.zhouhy.design.model.demo02.log.Log;
import org.zhouhy.design.model.demo02.log.impl.FileLog;

public class FileLogFactory implements LogFactory {
    
    /**
     * 具体的创建FileLog的逻辑
     * */
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
