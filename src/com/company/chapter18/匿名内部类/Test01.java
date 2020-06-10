package com.company.chapter18.匿名内部类;

/*
匿名内部类：
1。内部类
在类的内部有定义了一个新的类，被称为内部类
静态内部类
实例内部类
局部内部类
3. 使用内部类编写的代码，可读性很差，能不用金量不用
 */
public class Test01 {

    // 静态变量
    static String country;

    //    静态内部类
    static class Inner1 {
    }

    //实例内部类
    class Inner2 {
    }

    public void dosome() {
        //局部变量
        int i = 100;
        //局部内部类
        class Inner3 {
        }
    }

    public void doother() {
        new Test01().new Inner2();
    }

    public static void main(String[] args) {
        // 调用MyMath中的sum方法

        MyMath mm = new MyMath();
//        mm.sum(new ComputerImpl(),19,20);

        //匿名内部(局部内部类)类示范
        mm.sum(new Compute() {

            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        }, 100, 20);

    }

}

// 接口的实现类
class ComputerImpl implements Compute {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}

// 负责计算的接口
interface Compute {
    //抽象方法
    int sum(int a, int b);
}

// 数学类
class MyMath {
    // 数学求和方法
    public void sum(Compute c, int x, int y) {
        int res = c.sum(x, y);
        System.out.println(x + "+" + y + "=" + res);
    }
    // 接口就是引用类型，不要搞特殊化。
}