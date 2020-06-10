package com.company.chapter20.反射;

public class ReflectTest04 {
    public static void main(String[] args) {
        try {
            // 如果只希望静态代码块执行
            // 方法的执行导致类加载
            Class.forName("com.company.chapter20.反射.Myclass");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Myclass {
    // 静态代码块在类加载时执行,只执行一次
    static {
        System.out.println("执行了");
    }
}
