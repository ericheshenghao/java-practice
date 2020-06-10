package com.company.chapter20.IO流.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
        File f1 = new File("src/com/company/chapter20/IO流/File/Test02.java");
        // 获取文件名
        System.out.println(f1.getName());
        // 旁段是否是一个目录
        System.out.println(f1.isDirectory());

        System.out.println(f1.isFile());
        // 获取最后一次的修改时间
        System.out.println(f1.lastModified()); // 这个是毫秒
        // 将毫秒数转换成日期
        Date time = new Date(f1.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // 返回时间
        System.out.println(sdf.format(time));
        // 获取文件大小
        System.out.println(f1.length()); // 字节


    }
}
