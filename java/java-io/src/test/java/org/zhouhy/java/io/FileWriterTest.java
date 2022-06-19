package org.zhouhy.java.io;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    
    /**
     * 1 fileWriter.write('H'); 写单个字符到文件中
     * 2 注意writer一定要关闭, 否则字符是无法写入文件中的. 
     * 
     * */
    @Test
    public void testFileWriter1(){
        String filePath = "d://io//c.txt";
        FileWriter fileWriter = null;        
        try {
            fileWriter =  new FileWriter(filePath);
            fileWriter.write('H');
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.flush(fileWriter);
            IOUtil.close(fileWriter);
        }
    }

    @Test
    public void testFileWriter2(){
        String filePath = "d://io//c.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter =  new FileWriter(filePath, true);
            fileWriter.write("我爱你，亲爱的姑娘.");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.flush(fileWriter);
            IOUtil.close(fileWriter);
        }
    }
}
