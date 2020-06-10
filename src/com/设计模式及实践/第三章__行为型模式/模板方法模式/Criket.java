package com.设计模式及实践.第三章__行为型模式.模板方法模式;

public class Criket extends Game1 {
    @Override
    void initialize() {
        System.out.println("1");
    }

    @Override
    void startPlay() {
        System.out.println("2");
    }

    @Override
    void endPlay() {
        System.out.println("3");
    }
}
