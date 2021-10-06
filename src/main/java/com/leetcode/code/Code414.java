package com.leetcode.code;

public class Code414 {

    public static void main(String[] args) {

    }

    long INF = (long)-1e12;
    public int thirdMax(int[] nums) {
        long a = INF;
        long b = INF;
        long c = INF;
        for (int x : nums) {
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (a>x && x>b) {
                c = b;
                b = x;
            } else if (b>x && x>c) {
                c = x;
            }
        }
        return (int) (c == INF ? a : c);
    }

}
