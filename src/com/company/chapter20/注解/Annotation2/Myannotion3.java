package com.company.chapter20.注解.Annotation2;

public @interface Myannotion3 {
    String value();

    /*
    注解当中可以有哪些属性
    byte short int long float double boolen char Class 枚举
    以及他们的数组形式
     */
    int value1();

    String value2();

    int[] value3();

    String[] value4();

    Season value5();

    Season[] value6();

    Class paramtre();

    Class[] paramters();

}
