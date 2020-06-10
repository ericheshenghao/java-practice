package com.company.chapter20.IO流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
文件祖父输出流，负责写
从内存到硬盘
 */
public class Test06 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
//           fos=   new FileOutputStream("src/com/company/chapter20/IO流/temp.txt");
            // 可是写
            // 文件不存在时候会新建
            // 会把源文件清空掉在写入
            // 追加的方式在文件末尾写入，不会清空内容
            fos = new FileOutputStream("src/com/company/chapter20/IO流/temp.txt", true);
            byte[] bytes = {97, 98, 99, 100};
            fos.write(bytes);
            fos.write(bytes, 0, 2);

            // 写入一段话
            String s = "\b我是一个中国人，我骄傲";

            byte[] bytes1 = s.getBytes();
            fos.write(bytes1);

            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos == null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
