package com.leetcode.code;

public class Code667 {

    public static void main(String[] args) {

    }

}

class MapSum {

    TrieNode root;

    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode temp = this.root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i)-'a';
            if (temp.children[idx] == null) {
                temp.children[idx] = new TrieNode();
            }
            temp = temp.children[idx];
        }
        temp.val = val;
    }

    public int sum(String prefix) {
        TrieNode temp = this.root;
        // 判断是否存在该前缀
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)-'a';
            if (temp.children[idx] == null) {
                return 0;
            }
            temp = temp.children[idx];
        }
        return dfs(temp);
    }

    private int dfs (TrieNode node) {
        if (node == null) {
            return 0;
        }
        int res = node.val;
        for (TrieNode child : node.children) {
            res += dfs(child);
        }
        return res;
    }


    private class TrieNode {
        int val;
        TrieNode[] children = new TrieNode[26];
    }

}