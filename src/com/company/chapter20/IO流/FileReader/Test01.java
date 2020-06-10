package com.company.chapter20.IO流.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
文件字符流只能读取普通文本
 */
public class Test01 {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("src/com/company/chapter20/IO流/temp.txt");
            // 读 按照字符的方式读取，一次读取一个字符
            char[] chars = new char[4];
            int reedCount = 0;
            while ((reedCount = reader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, reedCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
