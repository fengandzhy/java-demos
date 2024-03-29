package org.zhouhy.simple_factory.demo01.factory;

import org.zhouhy.factory.demo01.product.Pizza;

import org.zhouhy.simple_factory.demo01.product.impl.MeatPizza;
import org.zhouhy.simple_factory.demo01.product.impl.VegetablePizza;

import java.util.Optional;

public class PizzaSimpleFactory {

    public static Optional<Pizza> createPizza(String pizzaType) {
        switch (pizzaType) {
            case "meat":
                return Optional.of(new MeatPizza());
            case "vegetable":
                return Optional.of(new VegetablePizza());
            default:
                return Optional.empty();
        }
    }
}
