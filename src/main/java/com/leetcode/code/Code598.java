package com.leetcode.code;

public class Code598 {

    public static void main(String[] args) {

    }

    public static int maxCount(int m, int n, int[][] ops) {
        int minx = m;
        int miny = n;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }
        return minx*miny;
    }

}
