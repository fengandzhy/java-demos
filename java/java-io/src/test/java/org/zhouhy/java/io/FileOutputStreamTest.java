package org.zhouhy.java.io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    @Test
    public void testWriteToFile1()  {
        String filePath = "d://io//b.txt";
        FileOutputStream fos = null;        
        try {
            fos = new FileOutputStream(filePath);
            String str = "Hello,world!";
            fos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 1. new FileOutputStream(filePath,true); 这里的true表示在文件末尾追加
     * 2. str.getBytes()的长度跟本身的str的长度是不一定相等的.
     * 3. fos.write(str.getBytes(),0,str.length()); 表示从流中下标为0的字符开始, 长度为str.length()的字节写入到文件中     
     * */
    @Test
    public void testWriteToFile2()  {
        String filePath = "d://io//b.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath,true);
            String str = "我爱你";
            fos.write(str.getBytes(),0,str.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
