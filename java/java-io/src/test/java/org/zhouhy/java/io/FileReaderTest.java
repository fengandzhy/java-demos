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
}
