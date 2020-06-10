package com.company.chapter19.string;

/*
如果要进行大量的字符串拼接，建议使用jdk中自带的
        StringBuffer
        StringBuilder
        jdk8
        buffer底层是一个char[]数组
    StringBuffer和StringBuilder的区别
    StringBuffer中的方法都有：synchronized关键字修饰。表示uStringBuffer中的方法在多线程环境下是安全的。
    StringBuffer是线程安全的
    StringBuilder是非线程安全的
 */
public class Test06 {
    public static void main(String[] args) {
        // 创建一个初始化容量为16个char的数组 字符串缓冲区对象
        StringBuffer stringBuffer = new StringBuffer();
        // 拼接字符串，以后拼接统一调用append()方法
        // 底层有一个数组扩容的方法，如果char数组满了。会自动扩容
        StringBuffer s1 = stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append(3.14);
        stringBuffer.append(1L);

        System.out.println(s1.toString());
    }
}
