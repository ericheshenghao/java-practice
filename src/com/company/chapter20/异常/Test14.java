package com.company.chapter20.异常;


// 自定义异常
public class Test14 {
    public static void main(String[] args) {
        MyException ex = new MyException("账号或者密码错误");
        ex.printStackTrace();
        ;
    }
}
