package com.company.chapter20.作业.武器数组;

public class Test {
    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        Gun gun = new Gun();

        Army army = new Army(2);

        army.addWeapon(rocket, 0);
        army.addWeapon(gun, 1);

        army.attackAll();
        army.moveAll();

    }
}
