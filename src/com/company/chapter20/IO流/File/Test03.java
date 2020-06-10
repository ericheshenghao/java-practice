package com.company.chapter20.IO流.File;

import java.io.File;

/*
listfile方法
获取当前目录下所有的子文件
 */
public class Test03 {
    public static void main(String[] args) {
        File f = new File("src/com/company/chapter20/IO流/File");
        File[] files = f.listFiles();

        for (File file : files
        ) {
            System.out.println(file);
        }
    }
}
