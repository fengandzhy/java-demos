package org.zhouhy.java.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class IOUtil {
    
    public static void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
