package org.zhouhy.java.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    
    /**
     * 1 fileReader.read()一次读取一个字符, 返回的是一个表示该字符的int值, 例如'我’返回的就是25105, 如果返回-1表示读取完毕.
     * 
     * */
    @Test
    public void testFileReader1(){
        String filePath = "d://io//a.txt";
        FileReader fileReader;
        int data;
        try {
            fileReader =  new FileReader(filePath);
            while((data = fileReader.read())!= -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1 fileReader.read(buf) 读取字符放到这个buf中, 返回的是读到的字符长度, 最多一次读取buf长度个字符, 返回-1说明读取完毕.
     * */
    @Test
    public void testFileReader2(){
        String filePath = "d://io//a.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int dataLength;
        try {
            fileReader =  new FileReader(filePath);
            while((dataLength = fileReader.read(buf))!= -1){
                System.out.print(new String(buf,0, dataLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.close(fileReader);
        }
    }
}
