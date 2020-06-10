package com.company.chapter19.数组;

/*
  关于数据类型
  数据类型            默认值
  ————————————————————————
  byte                0
  short               0
  int                 0
  long                0l
  float               0.0f
  double               0.0
  boolean             false
  char                 \u0000
  引用数据类型           null

  什么时候采用动态数组和静态数组，已知存储哪些具体元素，采用静态初始化，
  不确定时采用动态初始化，预先分配内存空间

 */
public class Test02 {
    public static void main(String[] args) {
        // 定义一个数组，采用动态初始化的方式船舰
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // 初始化一个人obj类型的数组
        Object[] objects = new Object[3];
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
