package org.zhouhy.factory.demo01.factory.impl;

import org.zhouhy.factory.demo01.factory.PizzaFactory;
import org.zhouhy.factory.demo01.product.Pizza;
import org.zhouhy.factory.demo01.product.impl.MeatPizza;

public class MeatPizzaFactory implements PizzaFactory {
    
    @Override
    public Pizza createCookedPizza(String meat) {
        MeatPizza meatPizza = new MeatPizza();        
        meatPizza.prepare();
        meatPizza.setMeat(meat);
        meatPizza.make();
        meatPizza.complete();
        return meatPizza;
    }

    @Override
    public Pizza createUncookedPizza() {        
        return new MeatPizza();
    }
}
