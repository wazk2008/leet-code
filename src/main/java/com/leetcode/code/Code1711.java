package com.leetcode.code;

public class Code1711 {

    public static void main(String[] args) {

    }

    public static int countPairs(int[] deliciousness) {
        int mod = (int)1e9+7;
        long res = 0;
        int len = deliciousness.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int a = deliciousness[i];
                int b = deliciousness[j];
                if (isOk(a, b)) {
                    res++;
                }
            }
        }

        return (int)(res%mod);
    }

    public static boolean isOk(int a, int b){
        long c = a + b;
        return (c&(c-1)) == 0;
    }

}
