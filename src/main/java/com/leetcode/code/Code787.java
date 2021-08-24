package com.leetcode.code;

import java.util.Arrays;

public class Code787 {

    public static void main(String[] args) {
        int k = 2;
        int n = 5;
        int[][] f = new int[k+2][n];
        for (int i = 0; i < k+2; i++) {
            Arrays.fill(f[i], INF);
        }

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j] + "\t");
            }
            System.out.println();
        }

    }

    static int INF = 1000007;


//    方法1：DFS+记忆化（memo）
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] memo = new int[n][k+2];
        int cost = dfs(flights, src, dst, k, memo);
        return cost >= INF ? -1 : cost;
    }

    private static int dfs(int[][] flights, int i, int dst, int k, int[][] memo){
        if (k < 0) {
            return INF;
        }
        if (i == dst) {
            return 0;
        }
        if (memo[i][k] != 0) {
            return memo[i][k];
        }

        int min = INF;
        for (int[] flight : flights) {
            if (flight[0] == i) {
                int cost = dfs(flights, flight[1], dst, k-1, memo) + flight[2];
                min = Math.min(min, cost);
            }
        }
        memo[i][k] = min;
        return min;
    }


//    方法二：动态规划
    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
//        f[t][i] 表示 行走t步 从src站到i站 的花费
//        k+2为长度，实际最大为k+1，经过k站，需要走k+1条边
        int[][] f = new int[k+2][n];
//        将f数组中的每个元素都填充为最大值
        for (int i = 0; i < k+2; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t < k+2; t++) {
            for (int[] flight : flights) {
                int j = flight[0];
                int i = flight[1];
                int cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t-1][j]+cost);
            }
        }
        int res = INF;
//        找到出一条【最多】经过 k 站中转的路线
//        src != dst 所以t从1开始
        for (int t = 1; t < k+2; t++) {
            res = Math.min(res, f[t][dst]);
        }

        return res == INF ? -1 : res;
    }



}
