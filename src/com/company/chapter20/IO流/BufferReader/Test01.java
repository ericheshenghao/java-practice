package com.company.chapter20.IO流.BufferReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 带有缓冲区的流
 不需要自定char数组，自带缓冲
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/com/company/chapter20/IO流/temp1.txt");
        // 当一个流的构造方法需要一个流的时候，这个被传尽来的流叫做：节点流
        //外部负责包装的这个流，叫做包装流，还有一个名字叫做处理流
        // 像FileReafer就是节点流
        BufferedReader br = new BufferedReader(reader);

        // 读一行
//        String firs = br.readLine();
//        System.out.println(firs);
//
//        String second = br.readLine();
//        System.out.println(second);
//
//        String thrid = br.readLine();
//        System.out.println(thrid);

        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
