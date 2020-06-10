package com.company.chapter20.IO流.数据流;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
DataInputStresm：数据字节输入流
只能使用这个去读，且需要知道写入的顺序
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("src/com/company/chapter20/IO流/temp2.txt"));
        // 开始读
        byte b = dis.readByte();
        short s = dis.readShort();
        int i = dis.readInt();
        long l = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        boolean readBoolean = dis.readBoolean();
        // 按顺序读出来
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        dis.close();

    }
}
