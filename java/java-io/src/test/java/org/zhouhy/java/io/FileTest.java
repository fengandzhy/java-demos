package org.zhouhy.java.io;

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
    
    public void testFileInfo(){
        File file = new File("d://io//a.txt");
        
    }
}
