package com.company.chapter20.注解.Annotation2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotion3 {
    String value();

    /*
    注解当中可以有哪些属性
    byte short int long float double boolen char Class 枚举
    以及他们的数组形式
     */
    int value1() default  234;

    String value2() default "";

    int[] value3() default  123;

    String[] value4() default "";

    Season value5() default  Season.SPRING;

    Season[] value6() default Season.SPRING;

    Class paramtre()  default String.class;

    Class[] paramters() default String.class;

}
