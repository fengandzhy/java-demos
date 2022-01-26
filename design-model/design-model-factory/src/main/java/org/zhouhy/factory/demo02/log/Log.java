package org.zhouhy.factory.demo02.log;

/**
 *  这是个产品的接口, 因为需要被创建的产品可能是五花八门的，我们需要给这些产品赋予一个统一的产品模板,
 *  这样一来, 工厂模式这里创建它们就方便多了, 否则在那个抽象工厂的接口里无法定义究竟返回哪个产品.  
 * */
public interface Log {    
    void writeLog(String destination);
}
