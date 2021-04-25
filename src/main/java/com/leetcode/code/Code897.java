package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Code897
 * @Author: ZK
 * @Date: 2021/4/25 23:09
 * @Version: 1.0
 */
public class Code897 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node2.left = node1;

        node3.left = node2;
        node3.right = node4;

        node8.left = node7;
        node8.right = node9;

        node6.right = node8;

        node5.left = node3;
        node5.right = node6;

        increasingBST(node5);
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);

        TreeNode dummyRoot = new TreeNode();
        TreeNode node = dummyRoot;

        for (Integer val : list) {
            node.right = new TreeNode(val);
            node = node.right;
        }

        return dummyRoot.right;
    }

    private static void midOrder(TreeNode node, List<Integer> list){
        if (node.left != null) {
            midOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            midOrder(node.right, list);
        }
    }


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