package com.company.chapter20.异常;
/*
获取异常简单的描述信息
String msg = exception.getMessage();
打印异常追踪的堆栈信息
exception.printStackTrace();
 */

public class Test08 {
    public static void main(String[] args) {
        // 异常要被抛出之后才会中断运行，否则只是对象
//   throw new NullPointerException("空指针异常");
        NullPointerException e = new NullPointerException("空指针异常");
        String msg = e.getMessage();
        System.out.println(msg);

        // 打印堆栈信息
        // 异步方式打印的
        e.printStackTrace();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        System.out.println("hellow");
    }
}
