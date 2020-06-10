package com.company.chapter19.Integer;

/*
 Integer中有哪些常用的方法？
 经典异常
 空指针异常
 数型转换异常
 数字格式化异常
 下标越界异常

 */
public class Test08 {
    public static void main(String[] args) {
        // 手动装箱
        // 构造方法
        Integer x = new Integer(1000);

        // 手动拆箱
        int y = x.intValue();
        System.out.println(y);

//        Integer a = new Integer("中文");

        //  重点犯法
        // static int parseInt(String s)
        // 静态方法 传参string 返回int
        // 将字符产转为int数字
        int retvalue = Integer.parseInt("213"); // String -->int NumberFormatException

        // 画瓢 转换为double 基本数据类型
        double d = Double.parseDouble("3.14");
        System.out.println(d);

        // valueOf方法作为了解
        // 静态的 int -- integer
        //
        System.out.println(Integer.valueOf(100));
        System.out.println(Integer.valueOf("100"));


    }
}
