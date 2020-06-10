package com.company.chapter20.注解;

/*
 注解 注释 annotation
 也是引用数据类型

 */
@MyAnnotation
public class Test01 {
    @MyAnnotation
    private int no;


    public Test01() {
    }

    @Deprecated
    public static void m1() {

    }

    @Deprecated
    public void m2() {

    }
}

@MyAnnotation
interface Myin {
}
