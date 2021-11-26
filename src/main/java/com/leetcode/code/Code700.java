package com.leetcode.code;

public class Code700 {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs (TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        } else if (node.val > val) {
            return dfs(node.left, val);
        } else {
            return dfs(node.right, val);
        }
    }

}
