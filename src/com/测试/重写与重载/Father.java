package com.测试.重写与重载;

/**
 * @author : heshenghao
 * @date : 15:23 2021/2/14
 */

class Main{
    public static void main(String[] args) {
        Father father = new Father();

        father.whoAmI();
        father.whoAmI("你的");
    }
}

class  child extends Father{
    @Override
    void whoAmI() {
        System.out.println("我是儿子");
    }
}
public class Father {

    void whoAmI(){
        System.out.println("我是爸爸");
    }


    // 不同参数数目
    Boolean whoAmI(String who){
        System.out.println("我是"+who+"的爸爸");
        return true;
    }
}
