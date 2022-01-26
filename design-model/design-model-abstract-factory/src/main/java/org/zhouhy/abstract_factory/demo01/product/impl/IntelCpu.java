package org.zhouhy.abstract_factory.demo01.product.impl;

import org.zhouhy.abstract_factory.demo01.product.Cpu;

public class IntelCpu implements Cpu {
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU 的针脚数" + pins);
    }
}
