package org.zhouhy.factory.demo01.factory;

import org.zhouhy.factory.demo01.product.Pizza;

public interface PizzaFactory {
    
    public Pizza createCookedPizza(String materials);
    
    public Pizza createUncookedPizza();
}
