package com.company.chapter19.数字;

import java.text.DecimalFormat;

/*
关于数字的格式化
 */
public class Test01 {
    public static void main(String[] args) {
        // 数字格式化

        /*
        #代表任意数字
        ，代表千分位
        . 代表小数点
        0 代表不够时候补零
         */

        DecimalFormat df = new DecimalFormat("###,###.##");
        String s = df.format(1234.56);
        System.out.println(s); //1,234.56

        DecimalFormat df2 = new DecimalFormat("###,###.0000");
        String s1 = df2.format(1234.56);
        System.out.println(s1); // 1,234.5600
    }


}
