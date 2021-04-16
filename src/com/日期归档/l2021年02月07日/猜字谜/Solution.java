package com.日期归档.l2021年02月07日.猜字谜;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : heshenghao
 * @date : 15:10 2021/2/26
 */
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i< puzzles.length;i++){

            for(int j=0;j<words.length;j++){
                boolean isValid = true;
                if(words[j].startsWith(puzzles[i].substring(0,1))){
                   for(int k=0;k < words[j].length();k++){
                       if(!puzzles[i].contains(words[j].substring(k,k+1))){
                           isValid = false;
                           break;
                       }
                   }
                }else{
                    isValid = false;
                }
                int incre = isValid == true?1:0;
                if(ans.size()==i) ans.add(i,incre);
                else ans.set(i,ans.get(i)+incre);
            }

        }
        return  ans;
    }
}