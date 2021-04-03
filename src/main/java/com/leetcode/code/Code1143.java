package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code1143
 * @Author: ZK
 * @Date: 2021/4/3 18:29
 * @Version: 1.0
 */
public class Code1143 {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

//    动态规划
    public static int longestCommonSubsequence(String text1, String text2) {
//        动态规划也是有套路的：
//        单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；
//        当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j]，其含义是在 A[0:i] 与 B[0:j]之间匹配得到的想要的结果。

//        官方题解
//        https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

}
