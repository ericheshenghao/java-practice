package com.company.chapter19.Integer;

public class Test09 {
    public static void main(String[] args) {
        // String -- int
        String s1 = "100";
        int i1 = Integer.parseInt(s1);
        System.out.println(i1 + 1); //101

        // int -- String
        String s2 = i1 + "";  // 101字符串
        System.out.println(s2 + 1); // 1001

        // int--Integer
        Integer x = 1000;

        // Integer -- int
        int y = x;

        //string -- integer
        Integer.valueOf("3124");
        // integer -- string
        String.valueOf(234);

    }
}
