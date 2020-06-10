package com.company.chapter18;

/*
    hashcode 方法
    这个方法不是抽象方法，带有native关键字，调用c++
     hashcode 方法 返回的是哈希码，实际上就是一个java对象的内存地址，经过哈希算法，的出的一个之，所以hashcode方法的执行结果可以等同看作一个java对象的内存地址

 */
public class Text07 {
    public static void main(String[] args) {
        Object o = new Object();
        int hashCodeValue = o.hashCode();
        System.out.println(hashCodeValue);
        Myclass mc = new Myclass();
        int hashcodeValue2 = mc.hashCode();
        System.out.println(hashcodeValue2);
        Myclass mc2 = new Myclass();

    }
}

class Myclass {
}