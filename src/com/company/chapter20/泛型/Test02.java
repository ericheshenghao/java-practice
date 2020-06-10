package com.company.chapter20.泛型;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;

/*
自动类型推断
 */
public class Test02 {
    public static void main(String[] args) {
        //ArrayList这里的类型会自动推断
        List<Animal> list = new ArrayList<>();
        list.add(new Animal());
        list.add(new Bird());
    }
}
