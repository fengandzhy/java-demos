package org.zhouhy.factory.demo01.product.impl;

import org.zhouhy.factory.demo01.product.Pizza;

public class VegetablePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("准备蔬菜");
    }

    @Override
    public void make() {
        System.out.println("制作蔬菜pizza");
    }

    @Override
    public void complete() {
        System.out.println("完成蔬菜pizza");
    }
}
