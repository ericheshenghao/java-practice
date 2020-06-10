package com.company.chapter20.反射;

import java.util.ResourceBundle;

/*
提供了一个资源绑定器，便于获取属性配置文件中的内容
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("info");

        System.out.println(bundle.getString("className"));

    }
}
