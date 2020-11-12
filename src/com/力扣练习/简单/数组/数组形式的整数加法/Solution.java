package com.力扣练习.简单.数组.数组形式的整数加法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 12:55 2020/10/21
 */
class Solution {
    public List<Integer> addToArrayForm(int[] a, int k) {
        LinkedList<Integer> rev = new LinkedList<>();
        int index =a.length-1;
        int next = 0;
        int res =0;
        while (k>0 || index>=0){
            int re = k%10;
            k=k/10;
            res = index>=0? a[index--]+re+next: re+next;

            if(res<10){
                next=0;
                rev.addFirst(res);
            }
            else {
                next = 1;
                rev.addFirst(res%10);
            }
        }
        if(next!=0) rev.addFirst(1);
        return rev;
    }

}