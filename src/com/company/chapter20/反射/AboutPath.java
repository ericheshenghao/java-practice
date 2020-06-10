package com.company.chapter20.反射;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/*
路径的问题
 */
public class AboutPath {
    public static void main(String[] args) throws IOException {
        // 通用的一种路径，即使代码换位置了，代码仍然是通用的
        // 注意：这个文件必须在类路径下
        // 凡是在src下的都是类路径
        // src是类的路径
        //getResource是类加载器的方法，当前默认从跟路径获取资源
//     String path=  Thread.currentThread().getContextClassLoader().getResource("info.properties").getPath();
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("info.properties");

        Properties pro = new Properties();
        pro.load(reader);
        reader.getClass();
        System.out.println(pro.getProperty("className"));
        System.out.println(pro.getProperty("className1"));

    }
}
