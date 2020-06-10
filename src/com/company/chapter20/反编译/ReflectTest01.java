package com.company.chapter20.反编译;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// 通过反射机制，反编译一个类的属性field
public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //
        StringBuilder s = new StringBuilder();

        Class student = Class.forName("java.lang.String");
        s.append(Modifier.toString(student.getModifiers()) + " class " + student.getSimpleName() + "{\n");
        Field[] fs = student.getDeclaredFields();

        for (Field field : fs
        ) {
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);

    }
}
