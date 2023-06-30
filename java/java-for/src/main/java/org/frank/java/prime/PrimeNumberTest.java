package org.frank.java.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberTest {
    public static void main(String[] args) {
        List<Integer> list = getPrimeNumbers(10);
        print(list);
    }
    
    private static List<Integer> getPrimeNumbers(int range){
        List<Integer> list = new ArrayList<>();
        
        for(int i=2;i<=range;i++){
            if(isPrimeNumber(i)){
                list.add(i);
            }
        }
        return list;
    }
    
    private static boolean isPrimeNumber(int number){
        boolean flag = true;
        int half = number / 2;
        for(int i=2;i<=half;i++){
            if(number % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    private static <E> void print(List<E> list){
        E[] e = (E[]) new Object[list.size()]; //创建泛型数组
        list.toArray(e);
        System.out.println(Arrays.toString(e));
    }
}
