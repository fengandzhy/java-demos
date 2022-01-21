package org.zhouhy.design.model.demo02.factory.impl;

import org.zhouhy.design.model.demo02.factory.LogFactory;
import org.zhouhy.design.model.demo02.log.Log;
import org.zhouhy.design.model.demo02.log.impl.DataBaseLog;

public class DataBaseLogFactory implements LogFactory {
    
    /**
     * 具体的创建DataBaseLog的逻辑
     * */
    @Override
    public Log createLog() {
        this.beforeCreateDataBaseLog();
        Log dbLog = creatingDBLog();
        this.afterCreateDataBaseLog();
        return dbLog;
    }
    
    private void beforeCreateDataBaseLog(){
        System.out.println("Before create database log.");
    }
    
    private DataBaseLog creatingDBLog(){
        System.out.println("creating DataBaseLog...");
        return new DataBaseLog();
    }
    
    private void afterCreateDataBaseLog(){
        System.out.println("After create database log.");
    }
}
