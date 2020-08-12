package com.company.chapter20.注解.Annotation2;

import com.company.chapter20.注解.MyAnnotation;

import java.lang.reflect.Method;

public class MyAnnotationTest {

    @MyAnnotation2(name = "heshenghao", color = "red", age = 12)

    public void dosome() {

    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Class c = Class.forName("com.company.chapter20.注解.Annotation2.MyAnnotationTest");
        Method dosome = c.getDeclaredMethod("dosome");

        if (dosome.isAnnotationPresent(MyAnnotation2.class)) {
            MyAnnotation2 m = dosome.getAnnotation(MyAnnotation2.class);
            System.out.println(m.color());
            System.out.println(m.age());
        }
    }

}
