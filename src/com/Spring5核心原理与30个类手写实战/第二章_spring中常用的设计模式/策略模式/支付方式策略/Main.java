package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.策略模式.支付方式策略;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("1", "2010209313", 111);
        PayState pay = order.pay(PayStrategy.StrategyKey.ALIPAY);
        System.out.println(pay);

    }
}

abstract class Payment{
    public  abstract  String getName();
    public abstract  double queryBalance(String uid);

    public PayState pay(String uid,double amout){
        if(queryBalance(uid)<amout){
            return  new PayState(500,"支付失败","余额不足");
        }
        return new PayState(200,"支付成功","支付金额："+amout);
    }

}

class AliPay extends Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    //模拟余额
    @Override
    public double queryBalance(String uid) {
        return 900;
    }
}

class WechatPay extends  Payment{

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 245;
    }
}


class UniPay extends Payment{
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 123;
    }
}

class JDPay extends Payment{
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}


 class PayState {

    private int code;
    private Object data;
    private String msg;

     public PayState(int code, Object data, String msg) {
         this.code = code;
         this.data = data;
         this.msg = msg;
     }

     @Override
     public String toString() {
         return "支付状态 {" +
                 "code=" + code +
                 ", data=" + data +
                 ", msg='" + msg + '\'' +
                 '}';
     }
 }

 class PayStrategy{

   private static Map<String,Payment> strategyMap = new HashMap<>();

   private static final String DEFAULT_STRATEGY = StrategyKey.ALIPAY;
    static {
        strategyMap.put(StrategyKey.ALIPAY,new AliPay());
        strategyMap.put(StrategyKey.WECHATPAY,new WechatPay());
        strategyMap.put(StrategyKey.UNIPAY,new UniPay());
        strategyMap.put(StrategyKey.JDPAY,new JDPay());
    }

    public static Payment get(String key){
        Payment payment = strategyMap.get(key);
        if(!strategyMap.containsKey(key)){
            return  strategyMap.get(DEFAULT_STRATEGY);
        }
        return payment;
    }

    interface StrategyKey{
        public String  ALIPAY= "ALIPAY";
        public String  WECHATPAY= "WECHATPAY";
        public  String  UNIPAY= "UNIPAY";
        public  String  JDPAY= "JDPAY";


    }
 }

 class Order{
    private String uid;
    private String orderId;
    private double amount;


     public Order(String uid, String orderId, double amount) {
         this.uid = uid;
         this.orderId = orderId;
         this.amount = amount;
     }

     public PayState pay(){
         return pay(PayStrategy.StrategyKey.ALIPAY);
     }

     PayState pay(String alipay) {
         Payment payment = PayStrategy.get(alipay);
         System.out.println("欢迎使用 "+payment.getName());
         System.out.println("本次交易金额为："+amount+",开始扣款");
         return  payment.pay(alipay,amount);
     }
 }
