package org.zhouhy.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    
    @Test
    public void testFileReader(){
        String filePath = "d://io//a.txt";
        FileReader fileReader = null;

        try {
            fileReader =  new FileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
