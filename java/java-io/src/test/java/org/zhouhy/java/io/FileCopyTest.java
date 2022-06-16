package org.zhouhy.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
    
    /**
     * 1. 拷贝文件的时候一定要用fos.write(bytes,0,readLength); 不能用 fos.write(bytes); 因为最后一次从输入流中读取的字符串并不一定就是bytes 的长度
     * 如果读取的长度是15个字节，但是bytes长度是1024, 所以用了fos.write(bytes); 就会导致文件失真. 
     * 
     * */
    @Test
    public void testFileCopy(){
        String srcFilePath = "d://io//a.png";
        String tarFilePath = "d://io//b.png";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[1024];
        int readLength = 0;
        try {
            fis = new FileInputStream(srcFilePath);
            fos = new FileOutputStream(tarFilePath);
            while((readLength = fis.read(bytes))!= -1){
                fos.write(bytes,0,readLength);
            }
            System.out.println("文件拷贝完毕.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
