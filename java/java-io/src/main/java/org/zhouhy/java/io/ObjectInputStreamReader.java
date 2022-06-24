package org.zhouhy.java.io;

import java.io.*;

public class ObjectInputStreamReader<T> {

    public T read( String filePath){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (T)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            IOUtil.close(objectInputStream);
            return null;
        }
    }
}
