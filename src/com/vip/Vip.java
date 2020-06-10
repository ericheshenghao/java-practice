package com.vip;

import com.company.Test06.Test06;

public class Vip extends Test06 {
    public void shopping() {

        // 本类同包、子类可以访问
        System.out.println(this.age);
//        System.out.println(this.name);
        System.out.println(this.weight);
    }
}
