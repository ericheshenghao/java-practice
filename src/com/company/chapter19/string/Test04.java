package com.company.chapter19.string;

/*
 类中的构造方法  String
 */
public class Test04 {
    public static void main(String[] args) {
        // 常用的构造方法
        String s1 = "hello";
        byte[] bytes = {97, 98, 99}; //97是a 98是b 99是c
        String s2 = new String(bytes);
        // 这里会自动掉用tostring方法 abc
        // 通过输出结果得出结论，string类已经重写了tostring方法，
        // 输出字符串对象的花，输出的不是对象的内存地址。而是字符串本身。
        System.out.println(s2);

        // 字节数组，数组元素下标的启示位置
        String s3 = new String(bytes, 1, 2);
        System.out.println(s3);
        // 经char数组的全部转换成字符串
        char[] chars = {'我', '是', '中', '国', '人'};
        String s4 = new String(chars);
        System.out.println(s4);
        String s5 = new String(chars, 2, 3);
        System.out.println(s5);


    }
}
