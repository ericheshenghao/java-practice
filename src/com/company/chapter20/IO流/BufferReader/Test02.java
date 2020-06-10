package com.company.chapter20.IO流.BufferReader;

import java.io.*;

/*
  转换流
  合并写法
 */
public class Test02 {
    public static void main(String[] args) throws IOException {

        // 字节流
        FileInputStream stream = new FileInputStream("src/com/company/chapter20/IO流/temp1.txt");
        // 通过转换流转换 极限套娃
        InputStreamReader reader = new InputStreamReader(stream);
        // 这个构造方式只能传一个字符流，不能传字节流
        // reader是节点流。br是包装流
        BufferedReader br = new BufferedReader(reader);

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }


        // 关闭最外层
        try {
            br.close();
        } catch (IOException e) {

        }

    }
}

