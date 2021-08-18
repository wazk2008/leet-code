package com.leetcode.code;

public class Code552 {

    public static void main(String[] args) {
        System.out.println(checkRecord(5));
    }

    static int MOD = 1000000007;

    public static int checkRecord(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }

    private static int dfs (int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }

//        遇到相同状态的记忆结果直接return
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }

//        开始递归回溯
        int res = 0;

//        "P" 随便放置
        res = (res + dfs(day+1, n, absent, 0, memo)) % MOD;

//        "A" 最多只能放置1个
        if (absent < 1) {
            res = (res + dfs(day+1, n, 1, 0, memo)) % MOD;
        }

//        "L" 最多连续放置2个
        if (late < 2) {
            res = (res + dfs(day+1, n, absent, late+1, memo)) % MOD;
        }

        memo[day][absent][late] = res;
        return res;
    }

}
