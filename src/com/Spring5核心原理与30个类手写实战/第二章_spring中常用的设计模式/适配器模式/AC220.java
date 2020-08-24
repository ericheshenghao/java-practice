package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.适配器模式;

public class AC220 {

    public int outputAC220V(){
        int output =220;
        System.out.printf("输出交流电 %d V %n", output);
        return  output;
    }

}


class main {
    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter(new AC220());
        System.out.println(powerAdapter.outputDC5V());
    }
}

interface  Dc5{
    int outputDC5V();
}

class PowerAdapter implements  Dc5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220){
        this.ac220 =ac220;
    }

    @Override
    public int outputDC5V() {
        int input = ac220.outputAC220V();
        // 变压器
        int output = input / 44;

        System.out.printf("使用 PowerAdapter 输入 AC: %d V 输出 DC: %d V",input,output);
        return  output;
    }
}
