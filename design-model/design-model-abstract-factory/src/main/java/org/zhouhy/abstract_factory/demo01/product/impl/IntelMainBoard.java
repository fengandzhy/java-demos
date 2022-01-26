package org.zhouhy.abstract_factory.demo01.product.impl;

import org.zhouhy.abstract_factory.demo01.product.MainBoard;


public class IntelMainBoard implements MainBoard {

    private int cpuHoles = 0;
    public IntelMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }
    
    @Override
    public void installCpu() {
        System.out.println("Intel主板的CPU插槽孔数：" + cpuHoles);
    }
}
