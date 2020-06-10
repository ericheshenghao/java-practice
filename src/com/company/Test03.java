package com.company;

public class Test03 {
    public static void main(String[] args) {
        D d = new G();
        E e = new G();
        F f = new G();

        d.m1();
        e.m2();
        f.m3();
        E e2 = (E) d;
        e2.m2();

        M m = new L();
//        // 接口和接口之间进行强制类型转换时，没有继承关系，也可以强转。
//        // 注意：运行时可能会出现classCastException
//        K k = (K) m;

//        改写
        if (m instanceof K) {
            K k = (K) m;
        }
    }
}

interface K {

}

interface M {

}

class L implements M {

}

// ________________________________________________________
interface D {
    void m1();
}

interface E {
    void m2();
}

interface F {
    void m3();
}

// 接口多实现
class G implements D, E, F {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {
        System.out.println("m2");
    }

    @Override
    public void m3() {

    }
}

