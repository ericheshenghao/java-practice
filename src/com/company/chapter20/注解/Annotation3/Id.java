package com.company.chapter20.注解.Annotation3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示只能出现在类上面
@Target(ElementType.TYPE)
//可以被反射机制读到
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
}

//必须有一个id