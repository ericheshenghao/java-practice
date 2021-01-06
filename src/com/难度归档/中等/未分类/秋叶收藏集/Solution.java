package com.难度归档.中等.未分类.秋叶收藏集;

class Solution {
    public int minimumOperations(String leaves) {
        int chosenRight = leaves.length()-1;
        int chosenLeft = 0;
        int res=0;

        boolean righthasShowR = false;
        if(leaves.charAt(chosenRight)=='y'){
            res++;
            righthasShowR =true;
        }
        while (chosenRight>leaves.length()/2){
            if(righthasShowR){
                if(leaves.charAt(chosenRight)=='r') res++;
            }
            if(!righthasShowR &&leaves.charAt(chosenRight)=='y') righthasShowR =true;
            chosenRight --;
        }

        boolean lefthasShowR = false;
        if(leaves.charAt(0)=='y'){
                res++;
            lefthasShowR =true;
        }
        while (chosenLeft<=leaves.length()/2){
           if(lefthasShowR){
               if(leaves.charAt(chosenLeft)=='r') res++;
           }
           if(!lefthasShowR &&leaves.charAt(chosenLeft)=='y') lefthasShowR =true;
            chosenLeft ++;
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int rrryyyrryyyrr = solution.minimumOperations(
                "ryyryyyrryyyyyryyyyrryrryryy");//4
        System.out.println(rrryyyrryyyrr);
    }
}