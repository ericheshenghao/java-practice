package com.company.chapter20.作业.武器数组;

public class Army {
    Weapon[] w;

    public Army(int w) {
        this.w = new Weapon[w];
    }

    void addWeapon(Weapon wa, int i) {
        w[i] = wa;
    }

    void attackAll() {
        for (int i = 0; i < w.length; i++) {
            w[i].attack();
        }
    }

    void moveAll() {
        for (int i = 0; i < w.length; i++) {
            w[i].move();
        }

    }

}
