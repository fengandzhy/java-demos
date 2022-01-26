package org.zhouhy.factory.demo01.client;

import org.zhouhy.factory.demo01.factory.PizzaFactory;

public class ChicagoPizzaStore extends AbstractPizzaStore{
    
    public ChicagoPizzaStore(PizzaFactory factory){
        super(factory);
    }
}
