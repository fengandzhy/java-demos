package org.zhouhy.javademos.mail;

import java.util.Date;

public class MyThread implements Runnable{
    public MyThread() {
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        //
        try {

            //EmailService service = new EmailServiceImpl();
            new Date();
            new EmailServiceImpl1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "仍然在执行。。。");
        //service.sendEmail(receiveMailAccount, "BSS系统工单", "<body><p>工单工号GGGGDADA</p></body>");
    }
}
