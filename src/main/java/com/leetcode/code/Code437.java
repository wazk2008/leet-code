package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Code437 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(0);
//        TreeNode node4 = new TreeNode(0);

//        node1.left = node2;
//        node2.left = node3;
//        node3.left = node4;

        System.out.println(pathSum(node1, 1));
    }

    static int res = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        // 记录路径中某个前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 防止包含跟节点的时候找不到
        map.put(0, 1);
        // dfs
        dfs(root, map, 0, targetSum);

        return res;
    }

    private static void dfs (TreeNode node, Map<Integer, Integer> map, int curSum, int targetSum) {
        // 递归结束条件
        if (node == null) {
            return;
        }

        // 判断是否存在符合条件的前缀和
        curSum += node.val;
        res += map.getOrDefault(curSum-targetSum, 0);

        // 将当前的前缀和记录下来
        map.put(curSum, map.getOrDefault(curSum, 0)+1);

        // dfs
        dfs(node.left, map, curSum, targetSum);
        dfs(node.right, map, curSum, targetSum);

        // 回溯，状态恢复
        map.put(curSum, map.getOrDefault(curSum, 0)-1);
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */