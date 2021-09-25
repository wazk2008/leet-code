package com.leetcode.code;

public class Code583 {

    public static void main(String[] args) {

    }

    public static int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        int len1 = chars1.length;
        char[] chars2 = word2.toCharArray();
        int len2 = chars2.length;

        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            char c1 = chars1[i-1];
            for (int j = 1; j <= len2; j++) {
                char c2 = chars2[j-1];
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int maxLen = dp[len1][len2];

        return len1-maxLen + len2-maxLen;
    }

}
