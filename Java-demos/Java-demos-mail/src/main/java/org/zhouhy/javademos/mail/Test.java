package org.zhouhy.javademos.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 这个只能在main函数中进行,不能放在test中
 * */
public class Test {

    //创建一个线程池，可装载大概3个线程任务的
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "fengandzhy@126.com";
    
    public static void main(String[] args) {
        executorService.submit(() -> EmailServiceFactory.getEmailService()
                .sendEmail(receiveMailAccount, "BSS系统工单", "<body><p>工单工号GGGGDADA</p></body>"));
        executorService.shutdown();
    }
}
