package org.zhouhy.java.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

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
    
    public static void flush(Flushable flushable){
        if(flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
