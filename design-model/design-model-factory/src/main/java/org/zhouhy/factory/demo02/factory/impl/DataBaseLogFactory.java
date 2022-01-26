package org.zhouhy.factory.demo02.factory.impl;

import org.zhouhy.factory.demo02.factory.LogFactory;
import org.zhouhy.factory.demo02.log.Log;
import org.zhouhy.factory.demo02.log.impl.DataBaseLog;

public class DataBaseLogFactory implements LogFactory {    
    /**
     * 具体创建DataBaseLog的逻辑,在现实中在创建具体产品的时候可能要实现不同的逻辑, 
     * 如果我们把具体的创建产品的逻辑暴露给客户端(就是需要使用这些产品的地方)的话, 如果产品创建逻辑发生改变的话,
     * 那么我们需要在所有用到该产品的地方统一更改逻辑，这样的话，就给代码造成很大匪负担.
     * 所以我们把创建产品的逻辑封装在这个工厂的代码里, 如果创建逻辑需要改变, 那么我们只需要在工厂里面改.
     * 
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
