package org.zhouhy.proxy;

/**
 * 1. 关于JDK动态代理
 *  1) 必须要有一个target类, 而且这个类必须实现了某个接口
 *  2) 实现了InvocationHandler 
 *  3) 创建代理的时候用Proxy.newProxyInstance
 *  4) 用 method.invoke(target,args); 来执行target的逻辑
 * 
 * 2. 关于cglib动态代理
 *  1) 必须要有一个target类, 这个类不能是final的, 因为final的类是不能有子类的
 *  2) 实现了MethodInterceptor接口
 *  3) 创建代理的时候用enhancer.create()
 *  4) 也是用method.invoke(targeet,objects); 来执行target的逻辑
 *  
 * 3. 
 *  
 *  
 *  
 * */
public class ProxyApp {
    public static void main(String[] args) {
        
    }
}
