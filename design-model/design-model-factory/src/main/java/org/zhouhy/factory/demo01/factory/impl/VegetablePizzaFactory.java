package org.zhouhy.factory.demo01.factory.impl;

import org.zhouhy.factory.demo01.factory.PizzaFactory;
import org.zhouhy.factory.demo01.product.Pizza;
import org.zhouhy.factory.demo01.product.impl.VegetablePizza;

public class VegetablePizzaFactory implements PizzaFactory {
    @Override
    public Pizza createCookedPizza(String materials) {
        VegetablePizza vegetablePizza = new VegetablePizza();
        vegetablePizza.prepare();
        vegetablePizza.setVegetable(materials);
        vegetablePizza.make();
        vegetablePizza.complete();        
        return vegetablePizza;
    }

    @Override
    public Pizza createUncookedPizza() {
        return new VegetablePizza();
    }
}
