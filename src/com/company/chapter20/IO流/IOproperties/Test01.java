package com.company.chapter20.IO流.IOproperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/*
io+properties

类似于这种文件，称为配置文件
并且当配置文件中的格式内容是
key=value
称作属性配置文件

 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        /*
        想将文件中的信息加载进来
         */
        // 一个输入流对象
        FileReader reader = new FileReader("src/com/company/chapter20/IO流/IOproperties/userinfo");
        Properties pro = new Properties();
        // 加载文件数据
        pro.load(reader);  // 文件肿得数据顺着管道加载到map集合里面

        String usernam = pro.getProperty("username");
        System.out.println(usernam);
        reader.close();
    }
}
