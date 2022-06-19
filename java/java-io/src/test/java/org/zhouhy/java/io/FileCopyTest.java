package org.zhouhy.java.io;

import org.junit.Test;

import java.io.*;

public class FileCopyTest {
    
    /**
     * 1. 拷贝文件的时候一定要用fos.write(bytes,0,readLength); 不能用 fos.write(bytes); 因为最后一次从输入流中读取的字符串并不一定就是bytes 的长度
     * 如果读取的长度是15个字节，但是bytes长度是1024, 所以用了fos.write(bytes); 就会导致文件失真. 
     * 
     * */
    @Test
    public void testFileCopy1(){
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
            IOUtil.close(fos);
            IOUtil.close(fis);
        }
    }

    /**
     * 1 这里表面上跟上面的没啥区别，但是有了BufferedInputStream/BufferedOutputStream 它使得这个流多了很多方法
     * 
     * */
    @Test
    public void testFileCopy2(){
        String srcFilePath = "d://io//a.png";
        String tarFilePath = "d://io//c.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] bytes = new byte[1024];
        int readLength = 0;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(tarFilePath));
            while((readLength = bis.read(bytes))!= -1){
                bos.write(bytes,0,readLength);
            }
            System.out.println("文件拷贝完毕.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(bos);
            IOUtil.close(bis);
        }
    }

    /**
     * 1 br.readLine() 读取一行,
     * 
     * */
    @Test
    public void testFileCopy3(){
        String srcFilePath = "d://io//a.txt";
        String tarFilePath = "d://io//c.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;        
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(tarFilePath));
            line = br.readLine();
            while(line!= null){
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            System.out.println("文件拷贝完毕.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(br);
            IOUtil.close(bw);
        }
    }
}
