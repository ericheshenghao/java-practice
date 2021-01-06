package com.难度归档.笔试;
import java.util.Scanner;
/**
 * @author : heshenghao
 * @date : 20:03 2020/12/20
 */
public class Solustion {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int all = sc.nextInt();
            int n = sc.nextInt();
            int[] price = new int[200000];
            int[] value= new int[200000];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < 2; j++){
                    if(j==0) {
                        price[i] = sc.nextInt();
                    }
                    if(j==1) {
                        value[i] = sc.nextInt();
                    }
                }
            }
            int dp = dp(price, value, all,n);
            System.out.println(dp);
        }

    public static int dp(int[] price,int[] value,int all,int n){
            int[] dp = new int[200000];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <=all ; j++) {
                if(j>= price[i]){
                    dp[j] =Math.max(dp[j],dp[j-price[i]]+value[i]);
                }
            }
        }
        return dp[all];
    }

}
