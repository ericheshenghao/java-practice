package com.company.chapter20.IO流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
使用 input'和outout完成文件的拷贝
文件的拷贝原理
文件的类型随意，什么样的文件都可以
 */
public class Test07 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("src/com/company/chapter20/IO流/1.mp4");

            fos = new FileOutputStream("src/com/company/chapter20/IO流/copy.mp4");
            // 读写 一次 1mb
            byte[] bytes = new byte[1024 * 1024];

            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, readCount);
            }

            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
