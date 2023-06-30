package org.frank.java.lambda.interfaces;

@FunctionalInterface
public interface  Creator<A,B,C,D> {
    D create(A a, B b, C c);
}
