package org.zhouhy.java.io;

import java.io.*;

public class OutputStreamWriter <T>{
    public void write(T t, String filePath){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.close(objectOutputStream);
        }
    }
}
