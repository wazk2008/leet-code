package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code264
 * @Author: ZK
 * @Date: 2021/4/11 00:06
 * @Version: 1.0
 */
public class Code264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = dp[p1] * 2;
            int num2 = dp[p2] * 3;
            int num3 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                p1++;
            }
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
        }
        return dp[n-1];
    }


}
