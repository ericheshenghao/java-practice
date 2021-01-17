package com.日期归档.l2021年01月17日.缀点成线;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x = coordinates[1][0] - x0;
        int y = coordinates[1][1] - y0;
        for (int i = 2; i < n; ++i) {
            int xi = coordinates[i][0] - x0;
            int yi = coordinates[i][1] - y0;
            if ((x * yi - y * xi)!=0) { //计算二阶行列式
                return false;
            }
        }
        return true;

    }
}