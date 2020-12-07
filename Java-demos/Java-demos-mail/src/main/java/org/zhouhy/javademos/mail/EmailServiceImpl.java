package org.zhouhy.javademos.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements EmailService{

    public static String myEmailAccount = "fengandzhy@126.com";
    public static String myEmailPassword = "LPGCHREJGCVUKUTS";
    public static String myEmailName = "ABC";
    // qq邮箱的SMTP服务器地址：smtp.qq.com
    public static String myEmailSMTPHost = "smtp.126.com";
    
    public EmailServiceImpl(){
        System.out.println("I am here!");
    }
    
    public void sendEmail(String hisEmail, String subject, String content) {
        try {
            System.out.println("ABCDEFG");
            final Properties props = new Properties(); // 参数配置
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.126.com");

            props.put("mail.user", myEmailAccount);
            // 发件人的密码
            props.put("mail.password", myEmailPassword);

            Authenticator authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };

            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress to = new InternetAddress(hisEmail);
            message.setRecipient(MimeMessage.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject(subject);

            // 设置邮件的内容体
            message.setContent(content, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
