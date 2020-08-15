package com.lamda表达式.第一章.runnable接口的匿名内部类;

public class Test01 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("inside thread construct using lamda");
        }).start();
    }
}


