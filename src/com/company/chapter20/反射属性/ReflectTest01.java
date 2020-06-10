package com.company.chapter20.反射属性;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取整个类
        Class student = Class.forName("com.company.chapter20.反射属性.Student");
        // 获取所有的field
        Field[] fileds = student.getFields();
        System.out.println(fileds.length);
        Field f = fileds[0];
        System.out.println(f.getName());

        // 获取所有的field
        Field[] fs = student.getDeclaredFields();
        System.out.println(fs.length);
        for (Field field : fs
        ) {
            System.out.println("===========================");
            System.out.println(field.getType().getSimpleName());

            System.out.println(field.getName());
            int mo = field.getModifiers();
            String name = Modifier.toString(mo);
            System.out.println(name);
        }

    }
}
