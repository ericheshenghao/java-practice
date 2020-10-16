package com.力扣练习.笔试.去哪儿网.计算题2;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m , n,num;
        int[] arr,dp;
        while (cin.hasNextInt()) {
            num = cin.nextInt();

            arr = new int[num];
            dp = new int[num+1];

            String[] strings = new String[num];
            String[] strings1 = new String[num];

//            System.out.println(num);

            for (int i=0; i<num; i++) {
                // 读取每行的a b c
                    strings[i] = cin.next();
            }

            for (int i=0; i<num; i++) {
                // 读取每行的a b c
                    strings1[i] = cin.next();
            }


            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if(strings1[i].equals(strings[j]) ){
                        arr[i] = j;
                    }
                }
            }

            
            int result1 = getResult1(num, dp, arr);
            
            System.out.println(result1);
        }


    }

 static int BinarySearch(int[] dp, int len, int n){
        int left = 1;
        int right = len;
        while(left < right){
            int mid = (left+right)/2;
            if(dp[mid] > n){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }

   static int getResult1(int n,int[] dp,int[] arr){
        dp[1] = arr[0];
        int index = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] > dp[index]){
                // 更新index
                dp[++index] = arr[i];
            }
            else{
                // 把dp数组中第一个大于n的数字替换为arr[i]
                int tempIndex = BinarySearch(dp, index, arr[i]);
                dp[tempIndex] = arr[i];
            }
        }
        return index;
    }
}