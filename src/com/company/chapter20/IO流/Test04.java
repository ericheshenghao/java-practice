package com.company.chapter20.IO流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
最终版
 */
public class Test04 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // 默认的当前路径在哪里
            // 工程project的根是当前路径
            fis = new FileInputStream("src/com/company/chapter20/IO流/temp.txt");
            byte[] bytes = new byte[128];

//            while (true){
//                int readCount = fis.read(bytes);
//                if(readCount==-1){
//                    break;
//                }
//                System.out.print(new String(bytes,0,readCount));
//            }

            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
            }


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
