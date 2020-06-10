package com.company.chapter20.IO流.对象流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test01 {
    public static void main(String[] args) throws IOException {
        Student s = new Student(111, "zhanshan");
        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student"));
        //刷新
        // 会报错，不支持序列化
        // serializable是一个标志性接口
        // 没有任何代码
        // 起到一个什么作用
        // 起到标识的作用，jvm会对这个类特殊待遇
        objectOutputStream.writeObject(s);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
