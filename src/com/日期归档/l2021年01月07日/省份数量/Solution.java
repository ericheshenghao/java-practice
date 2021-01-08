package com.日期归档.l2021年01月07日.省份数量;

/**
 * @author : heshenghao
 * @date : 13:33 2021/1/7
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int maxLen = isConnected.length;
        int circle = 0;
        boolean[] visited = new boolean[maxLen];
        for (int i = 0; i < maxLen; i++) {
            // 判断该城市是否已被访问
            if(!visited[i]){
                dfs(isConnected,visited,maxLen,i);
                circle++;
            }

        }
        return circle;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int maxLen, int i) {
        for (int j = 0; j < maxLen; j++) {
            if(isConnected[i][j]==1 && !visited[j]){
                visited[j]=true;
                dfs(isConnected,visited,maxLen,j);
            }
        }

    }

}