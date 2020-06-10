package com.company.chapter18;

/*
  tostring()方法
  目的是通过调用将java对象转化为字符串表示形式。

 */

class Mytime {


    public static void main(String[] args) {
        Test01 t1 = new Test01(1980, 1, 1);
        String s1 = t1.toString();
        System.out.println(s1);
    }
}

public class Test01 {
    int year;
    int month;
    int day;

    public Test01() {
    }

    public Test01(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
