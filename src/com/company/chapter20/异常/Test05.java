package com.company.chapter20.异常;


public class Test05 {
    public static void main(String[] args) {

        /*
         第二种方式，对异常进行捕捉
         */
        try {
            dosome();
        } catch (Exception e) {


        }
        ;


    }

    public static void dosome() throws ClassNotFoundException {
        System.out.println("dosome ");

    }
}
