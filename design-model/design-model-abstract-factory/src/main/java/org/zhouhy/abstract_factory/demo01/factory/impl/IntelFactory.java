package org.zhouhy.abstract_factory.demo01.factory.impl;

import org.zhouhy.abstract_factory.demo01.factory.AbstractFactory;
import org.zhouhy.abstract_factory.demo01.product.Cpu;
import org.zhouhy.abstract_factory.demo01.product.MainBoard;
import org.zhouhy.abstract_factory.demo01.product.impl.IntelCpu;
import org.zhouhy.abstract_factory.demo01.product.impl.IntelMainBoard;

public class IntelFactory implements AbstractFactory {
    
    @Override
    public Cpu createCpu() {
        System.out.println("这里是创建cpu的具体逻辑，被封装在这里了.");
        return new IntelCpu(755);
    }

    @Override
    public MainBoard createMainBoard() {
        System.out.println("这里是创建MainBoard的具体逻辑，被封装在这里了.");
        return new IntelMainBoard(755);
    }
}
