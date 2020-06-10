package com.company.chapter20.异常;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
使用trycatch捕捉异常
 */
public class Test06 {
    public static void main(String[] args) throws IOException {

        m2();
    }
    // 抛出FileNotFoundException的父对象可以的

    private static void m2() throws IOException {

        m3();
    }

    private static void m3() throws FileNotFoundException {
        // 创建一个输入流对象，该流指向一个文件
        // 为什么报错，因为在源代码的构造方法上有抛出异常
        new FileInputStream("D:\\素材\\test.txt");
    }
}
