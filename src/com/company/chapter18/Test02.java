package com.company.chapter18;

/*
    equals源代码
    public boolean equals (Object obj){
    return (this == obj);
    }
    默认采用双等号判断两个对象是否相等，不够用，判断的是地址，而我们需要旁段内容是否相等。
 */


import java.util.Objects;

public class Test02 {

    public static void main(String[] args) {
        int a = 100;
        int b = 100;

        // 旁段的是a中的100和b中保存的100是否相等
        System.out.println(a == b);

        // 判断两个java对象
        MyTime1 t1 = new MyTime1(2008, 8, 8);
        MyTime1 t2 = new MyTime1(2028, 8, 8);
        // 这里判断的是内存地址是否相等
        System.out.println(t1 == t2);

        // 重写方法之前 输出false
        boolean equals = t1.equals(t2);
        System.out.println(equals);

        MyTime1 t4 = null;
        System.out.println(t1.equals(t4));
    }
}

class MyTime1 extends Object {
    int year;
    int month;
    int day;

    public MyTime1() {
    }

    public MyTime1(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    //默认equals 方法
//     public boolean equals (Object obj){
//         return (this == obj);
//     }
    // 重写equals 方法
    // 怎么重写 比较内容
//     public boolean equals (Object obj){
//         // 当年相同，月相同，日相同 表示两个日期相同
//         int year1 = this.year;
//         int month1 = this.month;
//         int dat1=this.day;
//            // 向下转型 子类 mytime1
//         if(obj instanceof MyTime1){
//             MyTime1 t = (MyTime1) obj;
//             int year2 =t.year;
//             int month2=t.month;
//             int day2 = t.day;
//             if (year1==year2&&month1==month2&&dat1==day2){
//                 return true;
//             }
//         }
//         return false;
//     }


    @Override
    public boolean equals(Object o) {
        // 如果地址相同
        if (this == o) return true;
        // 如果o是null
        if (o == null || getClass() != o.getClass()) return false;
        MyTime1 myTime1 = (MyTime1) o;
        return year == myTime1.year &&
                month == myTime1.month &&
                day == myTime1.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
