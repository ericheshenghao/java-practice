package com.company.chapter20.注解.Annotation2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OtherAnnotation {
    int age();

    // 邮箱地址属性
    String[] email();

    Season[] value();


}
