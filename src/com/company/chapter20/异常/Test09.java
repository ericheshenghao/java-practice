package com.company.chapter20.异常;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
两个方法
String msg = exception.getMessage();
exception.printStackTrace();
 */
public class Test09 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            // 实际开发种使用这个，好习惯
//           java.io.FileNotFoundException: D:\素材\test1.txt (系统找不到指定的文件。)
//           at java.io.FileInputStream.open0(Native Method)
//           at java.io.FileInputStream.open(FileInputStream.java:195)
//           at java.io.FileInputStream.<init>(FileInputStream.java:138)
//           at java.io.FileInputStream.<init>(FileInputStream.java:93)
//           at com.company.chapter20.异常.Test09.m3(Test09.java:29)
//           at com.company.chapter20.异常.Test09.m2(Test09.java:24)
//           at com.company.chapter20.异常.Test09.m1(Test09.java:20)
//           at com.company.chapter20.异常.Test09.main(Test09.java:13)
            e.printStackTrace();

        }
        ;
        System.out.println("hellowworld");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {

        new FileInputStream("D:\\素材\\test1.txt");
    }

}
