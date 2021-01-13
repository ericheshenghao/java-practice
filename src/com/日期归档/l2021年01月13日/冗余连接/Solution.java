package com.日期归档.l2021年01月13日.冗余连接;

/**
 * @author : heshenghao
 * @date : 14:30 2021/1/13
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        // 父节点
        int[] parent = new int[nodesCount + 1];
        // 初始化
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 如何两个节点属于不同的连通分量
            if (find(parent, node1) != find(parent, node2)) {
                merge(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }
    // 合并
    public void merge(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    // 查找
    public int find(int[] parent, int index) {
        if (parent[index] == index) {
            return index;
        }
        return find(parent, parent[index]);
    }
}

