package org.zhouhy.model.singleton.md02;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: SingleTon
 * @BelongsPackage: com.bruceliu.demo2
 * @Author: bruceliu
 * @QQ:1241488705
 * @CreateTime: 2020-05-14 11:06
 * @Description: volatile关键字：
 *
 * volatile关键字保证多线程之间的可见性，这个关键字很有用，在并发包中和Netty框架大量用到这个关键字！
 */
public class VolatileDemo {

    volatile int x = 0;
    volatile boolean b = false;

    /**
     * 写方法
     */
    public void write() {
        x = 5;
        b = true;
    }

    /**
     * 读方法
     */
    public void read() {
        //如果b是false的话，那么这里无线循环，直到b=true的时候结束循环
        while (!b) {

        }
        System.out.println("x=>>>>" + x);
    }


}
