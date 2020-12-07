package org.zhouhy.javademos.mail;

public interface EmailService {

    /*
     * hisEmail收件人email
     * subject主题（标题）
     * content内容（文本）
     */
    void sendEmail(String hisEmail, String subject, String content);
}
