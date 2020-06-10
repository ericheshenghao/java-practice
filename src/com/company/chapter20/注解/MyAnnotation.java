package com.company.chapter20.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示只能修饰方法
//@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
}
