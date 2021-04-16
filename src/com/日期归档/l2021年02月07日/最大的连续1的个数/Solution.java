package com.日期归档.l2021年02月07日.最大的连续1的个数;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 21:43 2021/2/15
 */
class Solution {
    public int strToInt(String str) {
        char[] chars =  str.toCharArray();

        int ans = 0;
        for(char c:chars){
            // 负号
            if((int) c == 45){
                ans |= c;
            }
            // 数字
            if((int) c > 48 && (int) c < 57 ){
                ans <<=1;
                System.out.println(Integer.valueOf(c));
                ans |=  Integer.valueOf(c);
            }
        }

        System.out.println(ans);
        return 0;
    }
}