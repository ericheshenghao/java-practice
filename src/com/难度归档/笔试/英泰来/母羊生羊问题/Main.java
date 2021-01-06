package com.难度归档.笔试.英泰来.母羊生羊问题;


import java.util.Scanner;

public class Main {
    
     
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n1 = cin.nextInt();

        int n2 = cin.nextInt();
        int n3 = cin.nextInt();
        int n4 = cin.nextInt();
        int sheep = getSheep(n1,n2,n3,n4);
        System.out.println(sheep);
    }

    public static int getSheep( int n1,int n2,int n3 ,int n4) {
        int nums=1;
      for(int i =1;i<=n4;i++){
          if(i==n1){
              nums+=getSheep(n1,n2,n3,n4-1);
          }else if (i ==n2){
              nums+=getSheep(n1,n2,n3,n4-3);
          }else if(i==n3){
              nums--;
          }
      }

      return  nums;
    }
}

