package com.company.homework;

public class Test {
    public static void main(String[] args) {
        InsertDrawable mouse = new MouseImpl();
        Computer computer = new Computer(mouse);

        computer.insert();
    }
}
