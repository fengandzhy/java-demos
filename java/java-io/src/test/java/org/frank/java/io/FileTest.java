package org.frank.java.io;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FileTest {

    private static final Logger logger = LoggerFactory.getLogger(FileTest.class);
    
    @Test
    public void testCreateFile1(){
        String filePath = "d://io//a.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateFile2(){
        String directoryPath = "d://io";
        File directory = new File(directoryPath);
        String fileName = "a.txt";
        File file = new File(directory,fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateFile3(){
        String directoryPath = "d://io";        
        String fileName = "a.txt";
        File file = new File(directoryPath,fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testFileInfo(){
        File file = new File("d://io//a.txt");
        logger.info("文件名："+file.getName());
        logger.info("绝对路径："+file.getAbsolutePath());
        logger.info("父目录："+file.getParent());
        logger.info("文件大小："+file.length());
        logger.info("文件是否存在："+file.exists());
        logger.info("是否是个文件："+file.isFile());
        logger.info("是否是个目录："+file.isDirectory());
    }
    
    @Test
    public void testFileDelete(){
        String filePath = "d://io//a.txt";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                logger.info("文件删除成功");                        
            }else{
                logger.info("文件删除失败...");
            }
        }else {
            logger.info("文件不存在...");
        }
    }
}
