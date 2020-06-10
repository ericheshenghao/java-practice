package com.company.chapter19.枚举;

public class SwitchTest {
    public static void main(String[] args) {
        // 支持strng、int
        // 支持枚举
        switch (Season.AUTOMN) {
            case AUTOMN:
                System.out.println("秋天");
                break;
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
