package com.company.chapter19.Integer;

/*
1、8种基本的数据类型对应的包装类型是什么
基本数据类型             包装类型
—————————————————————————————————
byte                    java.lang.Byte（父类number）
short                   Short（父类number）
int                     Integer（父类number）
long                    Long（父类number）
float                   Float（父类number）
double                  Double（父类number）
boolean                 Boolean Object
char                    Character Object
2、以上八种包装类中、重点以Integer为嗲表进行学习，其他的类型依葫芦画瓢。
3、八种包装类种其中6个都是数字对应的包装类
  Number是个抽象类
  有各种方法负责拆箱
   xxValue()

 */
public class Test02 {
    public static void main(String[] args) {
        // 232这个基本数据类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换。
        // 基本数据类型-》抓换为->引用数据类型(装箱)
        Integer i = new Integer(232);
        // 将引用数据类型-- 转换为-》基本数据类型（拆箱）
        System.out.println(i);
        float f = i.floatValue();
        System.out.println(f);
        int intvalue = i.intValue();
        System.out.println(intvalue);
    }
}
