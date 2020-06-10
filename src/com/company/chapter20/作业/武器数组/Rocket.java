package com.company.chapter20.作业.武器数组;

public class Rocket extends Weapon {
    @Override
    public void attack() {
        System.out.println("火箭攻击");
    }

    @Override
    public void move() {
        System.out.println("火箭移动");
    }
}
