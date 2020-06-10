package com.company.chapter20.异常;

public class Test03 {
    public static void main(String[] args) {
        /*
         程序执行到此处发生了异常，main方法没有处理，将这个异常抛给了jvm
         终止了程序的运行
         ArithmeticException继承RuntimeException,属于运行时异常
         在编写程序阶段不需要对这种异常进行预先的处理。
         */
        System.out.println(100 / 0);
        System.out.println(21);
    }
}
