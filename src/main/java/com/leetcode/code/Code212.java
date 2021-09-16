package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code212 {

    public static void main(String[] args) {
        String[] words = {"hello", "world"};
        findWords(null, words);
    }

    // 上下左右移动的方向
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<String> findWords(char[][] board, String[] words) {
        // 结果集，去重
        Set<String> resultSet = new HashSet<>();

        // 构建字典树
        TrieNode root = buildTrie(words);

        // 获取board的行和列
        int row = board.length;
        int col = board[0].length;

        // 定义二维数组表示某个下标是否被访问过
        boolean[][] visited = new boolean[row][col];
        // 记录沿途遍历过的元素
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(resultSet, sb, board, i, j, root, visited);
            }
        }

        return new ArrayList<>(resultSet);
    }

    private static void dfs (Set<String> resultSet, StringBuilder sb, char[][] board, int i, int j, TrieNode node, boolean[][] visited) {
        // 判断越界、访问过、不在字典树中，直接返回
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || node.children[board[i][j]-'a']==null) {
            return;
        }

        // 记录递归到的当前字符
        sb.append(board[i][j]);

        // 如果有结束字符，将当前sb添加到结果集中
        if (node.children[board[i][j]-'a'].isEnd) {
            resultSet.add(sb.toString());
        }

        // 记录当前元素已访问
        visited[i][j] = true;

        // 按照上下左右的方向递归board
        for (int[] dir : dirs) {
            dfs(resultSet, sb, board, i+dir[0], j+dir[1], node.children[board[i][j]-'a'], visited);
        }

        // 回溯，状态还原
        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }


    // 构建字典树
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] arr = word.toCharArray();
            TrieNode curr = root;
            for (char c : arr) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        return root;
    }

}

class TrieNode{
    // 记录到这个节点是否是一个完整的单词
    boolean isEnd = false;
    // 孩子节点，题目说了都是小写字母，所以用数组，否则可以用HashMap替换
    TrieNode[] children = new TrieNode[26];
}