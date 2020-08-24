package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.策略模式;

import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      String key = PromotionKey.COUPON;
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(key));
        activity.excute();
    }
}


interface PromotionStrategy{
    void doPromotion();
}

class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程的价格直接抵扣");
    }
}

class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账户");
    }

}

class GroupBuyStrategy implements  PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，全团享团购价");

    }
}

class EmptyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}

class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excute(){
        promotionStrategy.doPromotion();
    }
}

class PromotionStrategyFactory{
    private static Map<String,PromotionStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(PromotionKey.COUPON,new CouponStrategy());
        strategyMap.put(PromotionKey.CASHBACK,new CashbackStrategy());
        strategyMap.put(PromotionKey.GROUPBUY,new GroupBuyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();
    private PromotionStrategyFactory(){}
    public static PromotionStrategy getPromotionStrategy(String key){
        PromotionStrategy promotionStrategy = strategyMap.get(key);
        return promotionStrategy ==null?NON_PROMOTION : promotionStrategy;
    }
}

interface PromotionKey{
    String COUPON= "COUPON";
    String CASHBACK= "CASHBACK";
    String GROUPBUY= "GROUPBUY";

}




