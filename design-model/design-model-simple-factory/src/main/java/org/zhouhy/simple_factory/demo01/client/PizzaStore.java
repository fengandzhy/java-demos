package org.zhouhy.simple_factory.demo01.client;


import org.zhouhy.factory.demo01.product.Pizza;
import org.zhouhy.simple_factory.demo01.factory.PizzaSimpleFactory;

import java.util.Optional;

public class PizzaStore {

    public void orderPizza(String pizzaType) {
        System.out.println("客户开始订购pizza ");
        Optional<Pizza> pizzaOptional = PizzaSimpleFactory.createPizza(pizzaType);
        if (pizzaOptional.isPresent()) {
            Pizza pizza = pizzaOptional.get();
            pizza.prepare();
            pizza.make();
            pizza.complete();
        }
    }
}
