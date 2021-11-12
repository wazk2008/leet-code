package com.leetcode.code;

public class Code375 {

    public static void main(String[] args) {
        getMoneyAmount(10);
    }

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return dfs(dp, 1, n);
    }

    private static int dfs(int[][] dp, int left, int right){
        if (left >= right) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int res = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int cost = i + Math.max(dfs(dp, left, i-1), dfs(dp, i+1, right));
            res = Math.min(res, cost);
        }
        dp[left][right] = res;
        return res;
    }

}
