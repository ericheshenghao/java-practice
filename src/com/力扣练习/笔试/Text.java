package com.力扣练习.笔试;

  class StringDemo{
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);
    }
}