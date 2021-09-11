package com.leetcode.code;

public class Code600 {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(9));


//        System.out.println(5 >> 0);
//        System.out.println(5 >> 1);
//        System.out.println(5 >> 2);
//        System.out.println(5 >> 3);
//        System.out.println(0b11111);
        System.out.println(findIntegers(0));
    }

    public static int findIntegers(int n) {
//        dp[x][0] 表示0开头的个数
//        dp[x][1] 表示1开头的个数
//        dp[x][1] = dp[x-1][0]
//        dp[x][0] = dp[x-1][0] + dp[x-1][1]

        int[][] dp = new int[32][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < 32; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        int len = Integer.toBinaryString(n).length();

        int pre = -1;
        int res = 0;
        while (len-- > 0) {
            int cur = n >> len & 1;
            if (cur == 1) {
                res += dp[len][0];
            }
            if (cur == pre && cur == 1) {
                break;
            }
            pre = cur;
        }
//        没有遇到break
        if (len == -1) {
            res++;
        }
        return res;
    }


    public static int findIntegers1(int n) {


        return 0;
    }

}
