package com.company.chapter20.异常;

/*
异常是以什么形式存在的
以类的形式存在，
/ 异常对应的现实生活中是怎样的
  火灾：（异常类）
      2008年8月8日 谁家着火了（异常对象）
  类是模板
  对象是：实际存在的个体

  钱包丢了：
       2008年的1月8日 钱包丢了 异常对象
 */
public class Test02 {
    public static void main(String[] args) {
        // 实例化异常对象
        NumberFormatException nfe = new NumberFormatException("数字格式化异常");

        System.out.println(nfe.toString());
        // 
        NullPointerException nfo = new NullPointerException("空指针异常");
        System.out.println(nfo);
        //
        ArithmeticException nft = new ArithmeticException("异常");
    }
}

