package com.company.chapter20.注解.Annotation2;

//import com.sun.org.apache.regexp.internal.RE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    /**
     * 我们在注解当中定义属性，以下这个是name属性
     * 看着像1一个方法
     *
     * @return
     */
    String name();

    String color();

    int age() default 20;
}
