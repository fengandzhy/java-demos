package org.zhouhy.javademos.mail;

public class EmailServiceFactory {

    public static EmailService getEmailService(){
        System.out.println("AAACC");
        return new EmailServiceImpl();
    }
}
