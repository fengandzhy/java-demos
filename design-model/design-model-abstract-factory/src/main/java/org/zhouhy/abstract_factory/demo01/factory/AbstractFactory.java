package org.zhouhy.abstract_factory.demo01.factory;

import org.zhouhy.abstract_factory.demo01.product.Cpu;
import org.zhouhy.abstract_factory.demo01.product.MainBoard;

public interface AbstractFactory {
    
    Cpu createCpu();
    MainBoard createMainBoard();
    
}
