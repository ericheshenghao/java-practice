package com.company.chapter19.数字;

import java.math.BigDecimal;

/*
BigDecimal 属于大数据，精度极高，不属于基本数据类型，属于java对象
专门用在财务软件当中
2.注意：财务软件中double是不够的，
 */
public class Test02 {
    public static void main(String[] args) {
        BigDecimal v1 = new BigDecimal(100);
        BigDecimal v2 = new BigDecimal(200);
        // 求和
        BigDecimal v3 = v1.add(v2);
        System.out.println(v3);
        BigDecimal v4 = v1.divide(v2);
        System.out.println(v4);

    }
}
