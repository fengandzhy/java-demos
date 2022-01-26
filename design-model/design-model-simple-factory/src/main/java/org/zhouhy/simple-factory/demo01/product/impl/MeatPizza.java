package org.zhouhy.factory.demo01.product.impl;

import org.zhouhy.factory.demo01.product.Pizza;

public class MeatPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备肉类");
    }

    @Override
    public void make() {
        System.out.println("制作肉类pizza");
    }

    @Override
    public void complete() {
        System.out.println("完成肉类pizza");
    }
}
