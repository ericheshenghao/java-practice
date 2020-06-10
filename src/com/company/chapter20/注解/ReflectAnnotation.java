package com.company.chapter20.注解;

import com.company.chapter20.注解.Annotation2.OtherAnnotation;

public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.company.chapter20.注解.Annotation2.Test02");
        // 旁段是否有注解
        System.out.println(c.isAnnotationPresent(OtherAnnotation.class));

        OtherAnnotation a = (OtherAnnotation) c.getAnnotation(OtherAnnotation.class);
        System.out.println(a.age());
        System.out.println(a.email());
    }
}
