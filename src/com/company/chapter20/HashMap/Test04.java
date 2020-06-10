package com.company.chapter20.HashMap;

import java.util.Properties;

/*
propertity属性对象
key和value都是string
属性类对象
 */
public class Test04 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        //方法 存取
        pro.setProperty("username", "root");
        pro.setProperty("pass", "123");

        // 
        System.out.println(pro.getProperty("pass"));


        pro.getProperty("username");
        pro.getProperty("username");
        pro.getProperty("username");
    }
}
