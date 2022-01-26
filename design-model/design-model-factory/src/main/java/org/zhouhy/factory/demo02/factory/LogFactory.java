package org.zhouhy.factory.demo02.factory;

import org.zhouhy.factory.demo02.log.Log;

/**
 * 这是一个抽象工厂，它不负责创建产品，它只是创建产品的共产提供模板
 * */
public interface LogFactory {    
    Log createLog();
}
