package org.zhouhy.design.model;

import org.junit.Test;
import org.zhouhy.design.model.demo02.factory.impl.DataBaseLogFactory;
import org.zhouhy.design.model.demo02.factory.impl.FileLogFactory;
import org.zhouhy.design.model.demo02.log.impl.DataBaseLog;
import org.zhouhy.design.model.demo02.log.impl.FileLog;

public class Demo2Test {

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
