package com.难度归档.中等.字符串.最长上升子序列;


public class Solution {
    /**
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS (int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int[] dp = new int[arr.length+1];
        int len = 1;
        dp[1]=arr[0];

        for(int i=1;i<arr.length;++i){
            if(arr[i]>dp[len]) dp[++len] = arr[i];
            else{

                    int l=1,r=len,pos=0;
                    while(l<=r){
                        int mid = (l+r)/2;
                        if(dp[mid]<arr[i]){
                            pos=mid;
                            l=mid+1;
                        }
                        else r=mid-1;
                    }
                    if(i==arr.length-1 && ((pos+1)!=len)){

                    }else{
                        dp[pos+1]= arr[i];
                    }

            }
        }
        int[] res = new int[len];
        int j=0;
        for (int i =1; i < len+1; i++,j++) {
            res[j] = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] lis = solution.LIS(new int[]{1,2,8,6,4});
        for (int li : lis) {
            System.out.println(li);
        }
    }
}