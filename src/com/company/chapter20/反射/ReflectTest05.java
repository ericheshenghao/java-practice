package com.company.chapter20.反射;

import java.io.File;
import java.lang.reflect.Field;

/*
如何通过反射机制获得一个java对象的属性？
给属性赋值
获取属性的值

 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception {

        // 我们


        Class student = Class.forName("com.company.chapter20.反射属性.Student");

        Object ob = student.newInstance();


        Field noField = student.getDeclaredField("no");
        // 给obj对象的no属性赋值


        noField.set(ob, 222); //给对象no属性复制2222

        Field nameFiel = student.getDeclaredField("name");
        // 加上这个就在外部还可以访问私有属性
        // 会留下漏洞
        nameFiel.setAccessible(true);
        nameFiel.set(ob, "jack");
        System.out.println(nameFiel.get(ob));
    }

}
