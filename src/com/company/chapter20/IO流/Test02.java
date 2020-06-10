package com.company.chapter20.IO流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
一次最多读取 b.length 个字符
减少交互
 */
public class Test02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // 默认的当前路径在哪里
            // 工程project的根是当前路径
            fis = new FileInputStream("src/com/company/chapter20/IO流/temp.txt");
            byte[] bytes = new byte[4];
            // 读取到的是字节数量。不是字节本身
            int readCount = fis.read(bytes); //4

            System.out.println(new String(bytes, 0, readCount)); //abcd

            int readCount1 = fis.read(bytes); //2

//            System.out.println(new String(bytes)); // efcd

            System.out.println(new String(bytes, 0, readCount1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    // 避免空指针异常
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
