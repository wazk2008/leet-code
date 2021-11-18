package com.leetcode.code;

public class Code563 {

    public static void main(String[] args) {

    }

    int res = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left);

        int rightSum = dfs(node.right);

        res += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }



}
