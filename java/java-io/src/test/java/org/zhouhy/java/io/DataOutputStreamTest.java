package org.zhouhy.java.io;

import org.junit.Test;

import java.io.*;

public class DataOutputStreamTest {
    
    
    /**
     * 1. 虽然 ObjectOutputStream 有类似的方法, 但是ObjectOutputStream 写入的数据DataInputStream 是无法读的
     * 同理, 如果是DataOutputStream 写入的数据 ObjectInputStream是无法读取的
     * */
    @Test
    public void testReadFromFile(){
        DataInputStream dis = null;
        DataOutputStream dos = null;
//        ObjectOutputStream oos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("d://io//user.dat"));
            dos.writeInt(4);
            dos.writeBoolean(true);
            dos.writeDouble(3.22d);
            dos.writeChar('A');
            dis = new DataInputStream(new FileInputStream("d://io//user.dat"));
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
            System.out.println(dis.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(dos);
            IOUtil.close(dis);
        }
    }
}
