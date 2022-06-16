package org.zhouhy.java.io;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    
    /**
     * fis.read() 读一个字节，并且把它转成ascii 码.
     * */
    @Test
    public void testReadFromFile1(){
        String filePath = "d://io//a.txt";
        FileInputStream fis;
        int readData = 0;
        try {
            fis = new FileInputStream(filePath);
            while ((readData = fis.read())!=-1){
                System.out.println((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
