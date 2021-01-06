package com.难度归档.简单.哈希表.岛屿的周长;

/**
 * @author : heshenghao
 * @date : 13:28 2020/10/30
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int res =0;
        int n = grid.length;
        int m = grid[0].length;
            for (int i =0;i<n;i++){
                for (int j=0;j<m;j++){
                    if(grid[i][j]==1){
                        // 上
                        if(i-1<0) res++;
                        else if( grid[i-1][j]==0) res++;
                        if(i+1>=n) res++;
                        else if(grid[i+1][j]==0) res++;
                        if(j-1<0) res++;
                        else if( grid[i][j-1]==0) res++;
                        if(j+1>=m) res++;
                        else if( grid[i][j+1]==0) res++;

                    }
                }
            }
            return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});

        System.out.println(i);
    }
}