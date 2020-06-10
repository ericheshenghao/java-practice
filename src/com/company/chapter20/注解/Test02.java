package com.company.chapter20.注解;

import com.company.chapter20.注解.Annotation2.MyAnnotation2;

public class Test02 {
    public static void main(String[] args) {
        Test01 t = new Test01();
        t.m2();
    }

    //属性名 =属性值
    @MyAnnotation2(name = "zhansan", color = "red")
    public void dosome() {

    }


    @Override
    public String toString() {
        return super.toString();
    }
}
