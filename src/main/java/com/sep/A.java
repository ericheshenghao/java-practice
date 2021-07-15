package com.sep;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: com.sep
 * @Description:
 * @date : 2021/7/15 20:45
 */
public class A {
    public static void main(String[] args) {

        MyClassLoader aa = new MyClassLoader();
        MyClassLoader bb = new MyClassLoader();
        try {
            Class<?> aClass = aa.loadClass("com.sep.B");
            Constructor<?> aconstructor = aClass.getConstructor(new Class[]{Integer.class});
            Object oa = aconstructor.newInstance(new Object[]{1});

            Class<?> bClass = bb.loadClass("com.sep.B");
            Constructor<?> bconstructor = bClass.getConstructor(new Class[]{Integer.class});
            Object ob = bconstructor.newInstance(new Object[]{2});

            // 最简单的类隔离
            Method printa = aClass.getMethod("print", new Class[0]);
            Method printb = bClass.getMethod("print", new Class[0]);
            printa.invoke(oa);
            printb.invoke(ob);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
