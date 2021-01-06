package com.难度归档.中等.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        int n =candidates.length;  //7
        List<List<Integer>> lists=new ArrayList<List<Integer>>(n);
        List<List<Integer>> newList=new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }




        for (int i = n-1; i >= 0 ; i--) {
            if(candidates[i]>target){
                continue;
            }
            if(candidates[i]==target){
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(target);
                if(!newList.contains(objects)){
                    newList.add(objects);
                }
            }
            lists.get(i).add(candidates[i]);

            dfs(newList,lists,candidates , i, lists.get(i),target);
        }

        return newList;
    }
    // 6 4 [6]
    private static void dfs(List<List<Integer>> newList,List<List<Integer>>  listList,int[] candidate, int index ,List<Integer> list,int target) {
        if(index==0)  return;
        // 4 [6]
        if(candidate[index]>target) return;


        // 序列大于零 且总和要小于target


        for (int i = index-1; i >= 0;i-- ) {


            if((candidate[i]+ list.stream().reduce((x,y)->x+y).orElse(0))<target){
                List<Integer> list1 = copyList(list);
                dfs( newList,listList,candidate,i,list1,target);
                list.add(candidate[i]);
                listList.add(list);


            }else if((candidate[i]+ list.stream().reduce((x,y)->x+y).orElse(0))==target){
                List<Integer> list1 = copyList(list);
                dfs( newList,listList,candidate,i,list1,target);
                list.add(candidate[i]);

                if(!newList.contains(list)){
                    newList.add(list);
                }

            }


        }

    }

    static List<Integer> copyList(List<Integer> list){
        ArrayList<Integer> objects = new ArrayList<>();
        for (Integer integer : list) {
            objects.add(integer);
        }
        return  objects;
    }

    public static void main(String[] args) {
       int[] candidates = new int[]{4,1,1,4,4,4,4,2,3,5};


       int target = 10;
        List<List<Integer>> lists = combinationSum2(candidates, target);

        System.out.println(lists);
    }
}