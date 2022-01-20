package org.zhouhy.design.model.demo01.factory;

import org.zhouhy.design.model.demo01.product.Pizza;

public interface PizzaFactory {
    
    public Pizza createCookedPizza(String materials);
    
    public Pizza createUncookedPizza();
}
