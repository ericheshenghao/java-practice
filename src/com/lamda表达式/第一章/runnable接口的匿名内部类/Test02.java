package com.lamda表达式.第一章.runnable接口的匿名内部类;

public class Test02 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("inside thread construct using lamda");
        new Thread(r).start();
    }
}
