package com.力扣练习.笔试;

abstract class Animal{
    abstract void say();
}
  class Cat extends Animal{

    static  int i = 0;
    public Cat(){
        System.out.printf("I am a cat");

    }
    public static void main(String[] args) {
        Cat cat=new Cat();
    }

      @Override
    final   void say() {
            i=1;
      }

       void says(){
        i=2;
      }
  }