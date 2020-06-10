package com.company.chapter20.注解.Annotation2;

@OtherAnnotation(age = 26, email = {"zhansan"}, value = {Season.SPRING, Season.WINTER})
public class Test02 {

    @OtherAnnotation(age = 26, email = {"zhansan"}, value = {Season.SPRING, Season.WINTER})
    public void dosome() {

    }

    // 如果数组中只有一个元素，大括号可以省略
    @OtherAnnotation(age = 26, email = "zhansan", value = {Season.SPRING, Season.WINTER})
    public void dosome1() {

    }
}
