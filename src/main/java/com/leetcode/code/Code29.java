package com.leetcode.code;

public class Code29 {

    public static void main(String[] args) {
        System.out.println(divide(62,4));
    }

    public static int divide(int dividend, int divisor) {
        if ( dividend==Integer.MIN_VALUE && divisor==-1 ) {
            return Integer.MAX_VALUE;
        }
        if ( dividend==Integer.MIN_VALUE && divisor==1 ) {
            return Integer.MIN_VALUE;
        }
        if ( dividend==Integer.MAX_VALUE && divisor==1 ) {
            return Integer.MAX_VALUE;
        }
        if ( dividend==Integer.MAX_VALUE && divisor==-1 ) {
            return Integer.MIN_VALUE+1;
        }

        // 除数
        int minusDividend = dividend > 0 ? 0-dividend : dividend;
        // 被除数
        int minusDivisor = divisor > 0 ? 0-divisor : divisor;

        int res = 0;
        while(minusDividend <= minusDivisor) {
            int temp = minusDivisor;
            int count = 1;
            while( minusDividend-temp <= temp ) {
                temp <<= 1;
                count <<= 1;
            }
            minusDividend -= temp;
            res += count;
        }

        if ( (dividend>0 && divisor<0) || (dividend<0 && divisor>0) ) {
            return 0-res;
        }

        return res;
    }

}
