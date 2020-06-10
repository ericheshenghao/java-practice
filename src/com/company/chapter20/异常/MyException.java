package com.company.chapter20.异常;

/*
自定义异常
第一步：编写一个类继承Exception或者RuntimeException
第二部：提供两个构造方法，一个无参数的，一个带String参数

 */
// 编译时异常
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

// 运行时异常

//public class Test14 extends RuntimeException {
//    public Test14() {
//    }
//
//    public Test14(String message) {
//        super(message);
//    }
//}