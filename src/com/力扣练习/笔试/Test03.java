package com.力扣练习.笔试;

  class ZeroTest {
    public static void main(String[] args) {

        try{
            int i = 100 / 0;
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }

}