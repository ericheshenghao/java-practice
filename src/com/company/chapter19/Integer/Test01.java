package com.company.chapter19.Integer;

/*
 1.java中为8中基本数据类型准备了8中包装类型，属于引用数据类型，父类是Object。
 2、思考：为什莫还需要8中包装类，
    因为8中数据类型不够用
 */
public class Test01 {
    public static void main(String[] args) {
        // 有没有这种需求： 调用dosome需要传入一个数字进去
        // 但是数字属于基本数据类型，而dosome方法参数的类型是Obejct
        // 可见dosome方法无法接收基本的数据类型的数字。可以传一个包装类进去
        // 把100这个数字经过构造方法包装成对象
        MyInt myInt = new MyInt(100);
        // 不能直接船100，但可以包装之后再传入
        dosome(myInt);
    }

    public static void dosome(Object obj) {
        System.out.println(obj);
    }
}
