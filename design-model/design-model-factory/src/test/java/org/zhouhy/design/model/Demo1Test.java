package org.zhouhy.design.model;

import org.junit.Test;
import org.zhouhy.design.model.demo01.client.AbstractPizzaStore;
import org.zhouhy.design.model.demo01.client.ChicagoPizzaStore;
import org.zhouhy.design.model.demo01.client.NewYorkPizzaStore;
import org.zhouhy.design.model.demo01.factory.PizzaFactory;
import org.zhouhy.design.model.demo01.factory.impl.MeatPizzaFactory;
import org.zhouhy.design.model.demo01.factory.impl.VegetablePizzaFactory;
import org.zhouhy.design.model.demo01.product.Pizza;
import org.zhouhy.design.model.demo01.product.impl.MeatPizza;
import org.zhouhy.design.model.demo01.product.impl.VegetablePizza;

public class Demo1Test {
    
    @Test
    public void test1(){
        PizzaFactory factory = new MeatPizzaFactory();
        AbstractPizzaStore store = new NewYorkPizzaStore(factory);
        Pizza pizza = store.orderPizza("cooked","beef");
        System.out.println(((MeatPizza)pizza).getMeat());
    }

    @Test
    public void test2(){
        PizzaFactory factory = new VegetablePizzaFactory();
        AbstractPizzaStore store = new ChicagoPizzaStore(factory);
        Pizza pizza = store.orderPizza("cooked","spinach");
        System.out.println(((VegetablePizza)pizza).getVegetable());
    }
}
