package com.lamda表达式.第一章.函数式接口;


public class Test01{
    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface PalindromeChecker{
   boolean isPalidrome(String s);
   
   default String dosome(){
       return "hello";
   }
   
   static void staticMethod(){
       System.out.println("im a static method");
   }
}

interface MyChildInterface extends PalindromeChecker {
    int anotherMehtod();
}
