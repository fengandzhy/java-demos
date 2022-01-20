package org.zhouhy.design.model.demo01;

import org.zhouhy.design.model.demo01.client.PizzaStore;


public class Demo01Test {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        store.orderPizza("meat");
    }
}
