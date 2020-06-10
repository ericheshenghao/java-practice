package com.company.chapter20.IO流.BufferReader;

import java.io.*;

/*
带有缓冲的字符输出流
 */
public class Test04 {
    public static void main(String[] args) throws IOException {
//        BufferedWriter out =new BufferedWriter(new FileWriter("src/com/company/chapter20/IO流/temp1.txt"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("src/com/company/chapter20/IO流/temp1.txt", true)));
        out.write("hello world");
        out.write("\n");
        out.write("234");
        out.flush();
    }
}
