package org.zhouhy.java;


/**
 * 1. 注意测试方法的命名whenCreateEmptyOptional_thenNull 
 * 
 * 2. 注意expect的写法 @Test(expected = NoSuchElementException.class)
 * 
 * 3. @Test(expected = Test.None.class) 用这种方式来断言没有异常发生
 * 
 * 4. 对于optional 来说, 你传一个null值给of 例如 Optional.of(null) 它会报出异常, 但是你如果传null给ofNullable 他不会报异常
 * 
 * 5. 对于ifPresent 来说如果返回为true, 就是里面有元素的话, 可以将这个元素直接传入consumer 
 * 
 * 
 * */
public class OptionalApp {
    public static void main(String[] args) {
        
    }
}
