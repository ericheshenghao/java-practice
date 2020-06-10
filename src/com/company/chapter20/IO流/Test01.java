package com.company.chapter20.IO流;
/*
文件字节输入流、万能的、任何类型的文件都可以采用这个流来读取
 */

import java.io.FileInputStream;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\web\\untitled1\\src\\com\\company\\chapter20\\IO流\\temp.txt");
//           Integer s = file.read(); //返回值是读取到的字节的本身
//        System.out.println(s);//97
//
//            Integer s1 = file.read(); //返回值是读取到的字节的本身
//            System.out.println(s1);//98
            while (true) {
                int readData = file.read();
                if (readData == -1) {
                    break;
                }
                System.out.println(readData);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    // 避免空指针异常
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
