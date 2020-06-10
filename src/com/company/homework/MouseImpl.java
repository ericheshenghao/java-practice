package com.company.homework;

public class MouseImpl implements InsertDrawable {

    @Override
    public void insert() {
        System.out.println("鼠标插上了");
    }

    @Override
    public void withdraw() {
        System.out.println("鼠标被拔出来了");
    }
}
