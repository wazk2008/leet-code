package com.leetcode.code;

public class Code671 {

    public static void main(String[] args) {

    }

    int res;
    int rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        rootVal = root.val;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if (node == null) {
            return;
        }
//        必须明确rootVal就是最小值，目标是比rootVal大的第一个值
        if (res != -1 && node.val >= res) {
            return;
        }
        if (node.val > rootVal) {
            res = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
