package com.leetcode.code;

public class Code372 {

    public static void main(String[] args) {
        pow(3, 5);
    }

    final static int MOD = 1337;
    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = b.length-1; i >= 0; i--) {
            res = (int)((long)res * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return res;
    }

    private static int pow (int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n%2 != 0) {
                res = (int)((long)res*x % MOD);
            }
            x = (int)((long)x*x % MOD);
            n /= 2;
        }
        return res;
    }

}
