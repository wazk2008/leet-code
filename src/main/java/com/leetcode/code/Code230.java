package com.leetcode.code;

import java.util.PriorityQueue;
import java.util.Queue;

public class Code230 {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        queue.add(1);
        queue.add(30);
        queue.add(5);
        queue.add(2);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
            System.out.println();
        }

    }

    public static int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        dfs(root, queue, k);
        return queue.peek();
    }

    private static void dfs (TreeNode node, Queue<Integer> queue, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, queue, k);
        if (queue.size() < k) {
            queue.add(node.val);
        } else {
            if (queue.peek() > node.val) {
                queue.poll();
                queue.add(node.val);
            }
        }
        if (queue.size() < k) {
            dfs(node.right, queue, k);
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

}

