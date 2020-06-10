package com.company.chapter20.反射.Construct;

public class ReflectTest13 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class stringClass = Class.forName("java.lang.String");

        //拿到父类
        Class superClass = stringClass.getSuperclass();

        System.out.println(superClass.getName());

        //实现的接口
        Class[] interfaces = stringClass.getInterfaces();
        for (Class in : interfaces
        ) {
            System.out.println(in.getName());
        }
    }
}
