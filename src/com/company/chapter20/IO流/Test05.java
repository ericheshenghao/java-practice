package com.company.chapter20.IO流;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
常用犯法
int available() 返回流当中剩余的没有读到的字节数量
long skip 跳过几个字节不读

 */
public class Test05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/com/company/chapter20/IO流/temp.txt");
//           int readByte =  fis.read();
            // 还剩下可以读的字节
//            System.out.println(fis.available());
//            // 用处 获得总的字节数量
//            byte[] bytes= new byte[fis.available()]; // 不适合太大的文件
//            // 直接读一次
//            int readCount = fis.read(bytes); // 6
//            System.out.println(new String(bytes)); //abcdef

            // skip跳过几个字节不读取，可能会用
            fis.skip(3);
            System.out.println(fis.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
