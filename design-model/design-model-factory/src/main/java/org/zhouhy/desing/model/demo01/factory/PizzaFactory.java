package org.zhouhy.desing.model.demo01.factory;

import org.zhouhy.desing.model.demo01.product.Pizza;

public interface PizzaFactory {
    
    public Pizza createCookedPizza();
    
    public Pizza createUncookedPizza();
}
