package com.company;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(MyMath.PI);
        // 常量能修改吗 不可以
//        MyMath.PI =3.1415928;
        // 接口的多态
        MyMath mm = new MyMathImpl();
        int res = mm.sub(10, 20);

        int res1 = mm.sum(10, 20);
    }
}

/*
 接口：
 1. 接口完全抽象
 2. 抽象类是半抽象的，接口是完全抽象的
 3. interface
 4. 接口支持多继承，一个接口可以继承多个接口
 5. 接口中只包含两部分内容，一部分是常量，一部分是抽象方法，没有其他内容了。
 6. 接口所有元素都是public的
 7. abstract 修饰付可以省略
 8. 接口中的常量public static  final 可以省略
 9. 接口中方法不能有方法体
 10. 一个非抽象类实现接口时候,必须将接口中所有方法加以实现.
 11. 一个类可以实现多个接口,
 12. extends 和 implements可以同时存在
 13. 使用接口,可以使用多态
 */

interface A {
    void m2();
}

interface B {
    void m2();
}

interface C extends A, B {
}

// 完全抽象
interface MyMath {
    // 常量
    // public static  final double PI=3.1415926;
    // public static  final 可以省略
    double PI = 3.1415926;

    // 可以省略 abstract
    public abstract int sum(int a, int b);

    // 可以有方法体吗？ 不能
    int sub(int a, int b);
}

// 编写一个类（一个非抽象类）
/*
    1. 接口实现 implements
    2.
 */
class MyMathImpl implements MyMath {

    @Override
    public int sum(int a, int b) {
        return 0;
    }

    @Override
    public int sub(int a, int b) {
        return 0;
    }
}