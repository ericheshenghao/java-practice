package com.日期归档.l2021年01月15日.移除最多的同行或同列石头;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : heshenghao
 * @date : 9:10 2021/1/15
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeStones(new int[][]{{0,1},{1,0},{1,2},{2,1},{2,2}});
    }

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone:stones){
            unionFind.union(stone[0] + 10000, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }
  private class UnionFind{
        private Map<Integer,Integer> parent;
        private int count;
        public UnionFind(){
            this.parent= new HashMap<>();
            this.count=0;
        }
      public int getCount() {
          return count;
      }
      public int find(int x){
            if(!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }
            // 路径压缩
            if(x!=parent.get(x)){
                parent.put(x,find(parent.get(x)));
            }
            return parent.get(x);
      }

      public void union(int x,int y){
            int rootX = find(x);
          int rootY = find(y);
          // 有相同的父节点，属于同一个连通分量
          if (rootX == rootY) {
              return;
          }
          // 合并这两个节点，连通分量-1
            parent.put(rootX,rootY);
          count--;
      }
    }
}