package com.company.chapter20.反射.Method;

public class ArgsTest {
    public static void main(String[] args) {
        m();
        m(1);
        m(1, 2, 3);
        m1("你好", 1, 2, 3, 4, 5);
        int[] ints = new int[4];
        m1("nihaop", ints);
        m1("heh");
    }

    // 可变长度参数
    //语法是类型后面...
    // 必须在最后一个位置上，且只能有一个
    // 可变长度参数可以当作数组来看待
    public static void m(int... arrgs) {
        System.out.println("执行了");
    }

    public static void m1(String name, int... arrgs) {

        System.out.println(arrgs.length);

        System.out.println("执行了");
    }

}
