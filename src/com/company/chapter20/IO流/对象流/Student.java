package com.company.chapter20.IO流.对象流;

import java.io.Serializable;

public class Student implements Serializable {


    private static final long serialVersionUID = -9069588558998955396L;
    private int no;
    private String name;

    // 新加入一行代码，类的源码改动了，需要重新编译
    // class文件再次运行的时候，生成的序列化版本号也会改变
    private int age2;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
