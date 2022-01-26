package org.zhouhy.factory.demo01.client;

import org.zhouhy.factory.demo01.factory.PizzaFactory;
import org.zhouhy.factory.demo01.product.Pizza;

public abstract class AbstractPizzaStore {
    private PizzaFactory factory;
    
    public AbstractPizzaStore(PizzaFactory factory){
        this.factory = factory;
    }

    public Pizza orderPizza(String type, String material){
        switch (type){
            case "cooked":
                return factory.createCookedPizza(material);
            case "uncooked":
                return factory.createUncookedPizza();
            default:
                return null;
        }
    }
}
