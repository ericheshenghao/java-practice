package com.company.chapter20.IO流.数据流;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
dataoutputStream 数据专属的流
这个文件不是普通的文本文档
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        //创建数据专属的字节输出流
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/com/company/chapter20/IO流/temp2.txt"));
        // 写数据
        byte b = 100;
        short s = 200;
        int i = 300;
        long l = 400l;
        float f = 3.0f;
        double d = 3.14;
        boolean sex = false;
        char c = 'a';
        // 写 数据类型也一并写入了
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);
        dos.flush();


    }
}
