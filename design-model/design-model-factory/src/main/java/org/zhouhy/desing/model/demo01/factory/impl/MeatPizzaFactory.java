package org.zhouhy.desing.model.demo01.factory.impl;

import org.zhouhy.desing.model.demo01.factory.PizzaFactory;
import org.zhouhy.desing.model.demo01.product.Pizza;

public class MeatPizzaFactory implements PizzaFactory {
    
    @Override
    public Pizza createCookedPizza() {
        return null;
    }

    @Override
    public Pizza createUncookedPizza() {
        return null;
    }
}
