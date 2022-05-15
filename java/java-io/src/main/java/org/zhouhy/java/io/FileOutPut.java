package org.zhouhy.java.io;

public class FileOutPut {
    public static void main(String[] args) {
        System.out.println(FileOutPut.class.getResource("").getFile());
        System.out.println(Thread.currentThread().getContextClassLoader ().getResource(""));
        System.out.println(FileOutPut.class.getClassLoader().getResource("").getFile());        
    }
}
