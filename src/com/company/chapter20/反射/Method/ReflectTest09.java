package com.company.chapter20.反射.Method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest09 {
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();

        Class userServiceClass = Class.forName("com.company.chapter20.反射.Method.Service.UserService");

        s.append(Modifier.toString(userServiceClass.getModifiers()) + " class " + userServiceClass.getSimpleName() + "{\n");

        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method : methods
        ) {
            s.append("\t");
            s.append(Modifier.toString(method.getModifiers()));
            s.append(" ");
            s.append(method.getReturnType().getSimpleName());
            s.append(" ");
            s.append(method.getName());
            s.append("(");
            // 参数
            Class[] parameter = method.getParameterTypes();
            for (Class p : parameter
            ) {
                s.append(p.getSimpleName());
                s.append(",");
            }


            s.append("){}\n");

        }
        s.append("}");

        System.out.println(s);

    }
}
