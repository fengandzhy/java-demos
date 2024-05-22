package org.frank.java17;

/**
 * 使用模式匹配的instanceof
 * 在这个例子中，如果obj是String类型的实例，
 * 那么obj会被自动转换成String类型的变量str，无需进行额外的显式类型转换。这不仅使得代码更简洁，而且减少了出错的可能性。
 * */
public class InstanceofExample {
    public static void main(String[] args) {
        Object obj = "Hello,world";
        if(obj instanceof String str){
            System.out.println(str.charAt(1000));
        }
    }
}
