package org.frank.java.lambda.interfaces;

@FunctionalInterface
public interface PredicateInterface<T> {
    boolean test(T t);    
}
