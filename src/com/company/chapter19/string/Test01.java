package com.company.chapter19.string;

/*
内置类：String java.lang.String
1.表示字符串类型。属于引用数据类型，不属于基本数据类型
2.双引号括起来的字符串，是不可变的，也就是说abc自出生到最终死亡，不可变。
3.都i是直接储存在方法区的字符串常量池当中的。
因为字符串在实际的开发使用中太频繁。为了执行效率，把字符串都放在一个池子里，
 */
public class Test01 {
    public static void main(String[] args) {
        // 引用类型 后面那个放在常量池中，前面的在mian栈帧中。s1有个地址类似0×1234 指向常量池中的字符串中
        String s1 = "abcf";

        // 分析代码中的”xt”是那里来的
        // 凡是双引号括起来的都在常量池中。
        // new对象的时候在堆内存中开辟空间
        String s3 = new String("xt");
    }
}
