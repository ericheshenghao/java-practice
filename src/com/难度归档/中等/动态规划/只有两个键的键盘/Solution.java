package com.难度归档.中等.动态规划.只有两个键的键盘;

/**
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;

        int[] dp= new int[n+1];

        dp[1]=0;

        for(int i=2;i<=n;i++){
            if(i%2==0) dp[i]=dp[i/2]+2;
            else{
                int divisor= divisorGenerator(i);

                dp[i]=dp[divisor]+i/divisor;
            }
        }

        return dp[n];
    }

    int divisorGenerator(int n){
        for(int i=n/2+1;i>0;i--){
            if (n%i == 0) return i;
        }
        return 0;
    }
}