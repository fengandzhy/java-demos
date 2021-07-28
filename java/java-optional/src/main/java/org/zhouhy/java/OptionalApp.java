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
 * 6. orElse()方法的意思是, 如果有值则返回该值，否则返回传递给它的参数值. userOptional.orElse(user2); 如果userOptional
 * 取不到, 则就返回user2
 * 
 * 7. orElse 和 orElseGet 的区别在于 当下面的user不为null时 orElse 仍然会去操作createNewUser()
 * 但是orElseGet 不会操作
 * Optional.ofNullable(user).orElse(createNewUser());
 * Optional.ofNullable(user).orElseGet(() -> createNewUser());
 * 
 * 8. 使用slf4j日志的方法
 *  1) private static final Logger logger = LoggerFactory.getLogger(OptionalTest.class);
 *  2) 使用@Slf4j 注解
 * */
public class OptionalApp {
    public static void main(String[] args) {
        
    }
}
