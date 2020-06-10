package com.company.chapter20.IO流.File;

import java.io.File;
import java.io.IOException;

/*
file类和四大家族没有关系，不能完成读和写
2代表文件或者目录路径名字的抽象表现形式
可能对应的是目录，也有可能是文件

 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("src/com/company/chapter20/IO流/File/Test01.java");
        // 判断是否存在
        System.out.println(f1.exists());
        // 如果不存在，则以文件的形式创建出来
        if (!f1.exists()) {
            // 创建文件
//            f1.createNewFile();
            // 创建单目录
//            f1.mkdir();
            // 创建多目录
            f1.mkdirs();
            // 获取文件的父路径

        }
        String path = f1.getParent();
        System.out.println(path);
        System.out.println(f1.getParentFile());
        System.out.println(f1.getAbsoluteFile());

        System.out.println(f1.getAbsolutePath());

    }
}
