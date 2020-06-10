package com.company.chapter20.异常;

/*
 报错的原因是什么
 因为方法声明位置上使用了：throws ClassNotFoundException
 而throws ClassNotFoundException是编译时异常，所以需要预先处理
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
          dosome 方法声明上有：  throws ClassNotFoundException
          在方法调用时必须对这种异常进行预先的处理
          如果不处理，编译器就会报错
          所与要在main方法上上抛异常
         */
        dosome();

    }


    // 使用了throws
    // 表示可能会出现ClassNotFoundException异常
    // 叫做类没有找到 父类是：Exception 属于编译时异常
    public static void dosome() throws ClassNotFoundException {
        System.out.println("dosome ");

    }
}
