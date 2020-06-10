package com.company.chapter19.Integer;

/*
    分析
 */
public class Test07 {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        /*
         java种为了提高效率，将-128到127之间的说有的包装对象提前创建好，放到了一个
         方法区的整数型常量池中，目的是只要用到就不需要再new了，
         因此 x和y保存的内存地址是一样的
         */
        Integer x = 127;
        Integer y = 127;
        // ==永远旁段的是两个对象地址
        System.out.println(x == y);
    }
}
