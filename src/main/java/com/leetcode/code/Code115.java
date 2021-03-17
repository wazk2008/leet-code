package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code115
 * @Author: ZK
 * @Date: 2021/3/17 23:27
 * @Version: 1.0
 */
public class Code115 {

    public static void main(String[] args) {

    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n-1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][0];
    }


}
