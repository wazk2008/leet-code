package com.leetcode.code;

public class Code10_1 {

    public static void main(String[] args) {

    }


    final static int MOD = 1000000007;
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int res = 0;
        int left = 0;
        int right = 1;
        for (int i = 2; i <= n; i++) {
            res = (left + right) % MOD;
            left = right;
            right = res;
        }

        return res;
    }

}
