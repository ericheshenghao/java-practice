package com.company.chapter20.IO流.标准输出流;
/*
标准的字节输出流 默认输出到控制台
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("hello world");

        PrintStream ps = System.out;

        ps.println("hello zhanshan ");
        ps.println("hello");

//        System.gc();
//        System.currentTimeMillis();
//        System.exit(0);
//        System.arraycopy();
        PrintStream printStream = new PrintStream(new FileOutputStream("src/com/company/chapter20/IO流/temp2.txt"));
        // 修改输出方向 输出到文件里面去了
        System.setOut(printStream);
        System.out.println("hello world");
        System.out.println("hello world1");
        System.out.println("hello world2");
    }
}
