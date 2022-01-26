package org.zhouhy.abstract_factory.demo01.product.impl;

import org.zhouhy.abstract_factory.demo01.product.MainBoard;

public class AmdMainBoard implements MainBoard {

    private int cpuHoles = 0;
    public AmdMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }
    
    @Override
    public void installCpu() {
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}
