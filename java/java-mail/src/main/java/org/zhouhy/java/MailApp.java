package org.zhouhy.java;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailApp {
    public static void main(String[] args) throws AddressException {
        InternetAddress internetAddress = new InternetAddress("22@123.com");
        System.out.println(internetAddress.getAddress());
    }
}
