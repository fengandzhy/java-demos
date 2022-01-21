package org.zhouhy.design.model;

import org.junit.Test;
import org.zhouhy.design.model.demo02.factory.impl.DataBaseLogFactory;
import org.zhouhy.design.model.demo02.factory.impl.FileLogFactory;
import org.zhouhy.design.model.demo02.log.impl.DataBaseLog;
import org.zhouhy.design.model.demo02.log.impl.FileLog;

public class Demo2Test {
    
    /**
     * 这里是需要使用产品的地方, 但是产品的创建逻辑在这里是不可见的, 我们这里要做的只是创建一个负责创建产品的工厂，
     * 在工厂里封装了具体创建产品的逻辑.
     * 
     * 使用了共产模式,就是把创建逻辑和使用逻辑解耦合.
     * */
    @Test
    public void test1(){
        DataBaseLogFactory dbLogFactory = new DataBaseLogFactory();
        DataBaseLog dbLog = (DataBaseLog) dbLogFactory.createLog();
        dbLog.writeLog("DB");
    }

    @Test
    public void test2(){
        FileLogFactory fileLogFactory = new FileLogFactory();
        FileLog fileLog = (FileLog) fileLogFactory.createLog();
        fileLog.writeLog("File");
    }
}
