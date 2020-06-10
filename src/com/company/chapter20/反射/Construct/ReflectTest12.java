package com.company.chapter20.反射.Construct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest12 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Vip v1 = new Vip();
        Vip v2 = new Vip(110, "zhangshan");

        Class c = Class.forName("com.company.chapter20.反射.Construct.Vip");
        Object o = c.newInstance();
        System.out.println(o);
        Constructor con = c.getDeclaredConstructor(int.class, String.class, String.class, boolean.class);
        // 创建
        Object obj = con.newInstance(110, "zhnahsan", "1990", true);


        Constructor con2 = c.getConstructor();
        Object o3 = con2.newInstance();
        System.out.println(o3);
    }
}
