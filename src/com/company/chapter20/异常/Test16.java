package com.company.chapter20.异常;

/*
方法覆盖
重写之后的方法不能抛出更多的异常更宽泛的异常 可以更少
 */
public class Test16 {
}


class Animal {
    public void doSome() {

    }

    public void doOther() throws Exception {

    }
}

class Cat extends Animal {
    // 正常
//    public void doOther() {
//
//    }
    // 正常 可以更少
    public void doOther() throws NullPointerException {

    }

}

