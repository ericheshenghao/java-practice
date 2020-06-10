package com.company.chapter19.日期处理;

/*
获取1970年距离当前时间的距离
简单总结一下相关属性和方法
System.out 是System类的静态变量
.println() println方法不是System类的，是PrintStream类的方法
System.gc()
System.currentTimeMillis()
System.exit(0) 退出jvm
 */
public class Test02 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(now); //1586937265311
        // 统计一个方法耗时
        // 在调用前记录一个人毫秒谁
        long begin = System.currentTimeMillis();
        print();
        long end = System.currentTimeMillis();
        System.out.println("耗费毫秒数量：" + (end - begin));
        // 在执行后记录一个毫秒数
    }


    // 需求 统计一个方法执行所耗费的时间
    public static void print() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("i= " + i);
        }
    }
}
