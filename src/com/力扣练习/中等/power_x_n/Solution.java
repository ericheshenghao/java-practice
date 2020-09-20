package com.力扣练习.中等.power_x_n;

class Solution {
    static public double myPow(double x, int n) {

        double res = x;

        if(n==0){
            return 1;
        }

        if(x==1){
            return 1;
        }

        if(n<0){
            x =1/x;
            res = x;

            for (int i = 0; i <  -n-1; i++) {
                res= res*x;
            }
        return  res;
        }


        for (int i = 0; i <  n-1; i++) {
            res= res*x;
        }



        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }
}