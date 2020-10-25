package org.zhouhy.java8.interfaces;


@FunctionalInterface
public interface AppleComparator<T>{
    int compare(T o1, T o2);
}
