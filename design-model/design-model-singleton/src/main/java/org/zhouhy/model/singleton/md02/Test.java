package org.zhouhy.model.singleton.md02;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {


        final VolatileDemo volatileDemo=new VolatileDemo();

        //匿名内部类写法
        Thread thread1=new Thread(volatileDemo::write);


        Thread thread2=new Thread(volatileDemo::read);

        //让线程2先运行
        thread2.start();

        //睡眠
        TimeUnit.MILLISECONDS.sleep(1);

        //设置false，按照常理  b=true  循环条件是false 那么空转的循环应该结束
        thread1.start();

        thread1.join();
        thread2.join();

        //线程1和线程2结束，main线程执行
        System.out.println("执行结束！！！");
    }
}
