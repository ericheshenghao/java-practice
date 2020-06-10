package com.company.chapter20.反射.Construct;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectTest11 {
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();
        Class vipclass = Class.forName("com.company.chapter20.反射.Construct.Vip");
        s.append(Modifier.toString(vipclass.getModifiers()));
        s.append(" class ");
        s.append(vipclass.getSimpleName());
        s.append("{\n");

        // 拼接的构造方法
        Constructor[] constructors = vipclass.getConstructors();
        for (Constructor c : constructors
        ) {
            s.append("\t");

            s.append(Modifier.toString(c.getModifiers()));
            s.append(" ");
            s.append(vipclass.getSimpleName());
            s.append("(");
            Class[] params = c.getParameterTypes();
            for (Class param : params
            ) {
                s.append(param.getSimpleName());
                s.append(",");

            }

            if (params.length > 0) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append("){}\n");

        }
        s.append("}");

        System.out.println(s);
    }
}
