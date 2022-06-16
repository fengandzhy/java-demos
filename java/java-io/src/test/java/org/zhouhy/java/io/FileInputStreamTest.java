package org.zhouhy.java.io;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    
    /**
     * fis.read() 从流中读一个字节 如果返回-1表示读取完毕
     * */
    @Test
    public void testReadFromFile1()  {
        String filePath = "d://io//a.txt";
        FileInputStream fis = null;
        int readData = 0;
        try {
            fis = new FileInputStream(filePath);
            while ((readData = fis.read())!=-1){
                System.out.println((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * fis.read(bytes) 表示从流中读取bytes.Length 长度的字节放到byte中去. 
     * readLength 表示其读到的字节数.
     * 因为一个汉字是3个字符, 这里读取9个字节, 刚好把三个字读完.
     * */
    @Test
    public void testReadFromFile2()  {
        String filePath = "d://io//a.txt";
        FileInputStream fis = null;
        byte[] bytes = new byte[9];
        int readLength = 0;
        try {
            fis = new FileInputStream(filePath);
            while ((readLength = fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
