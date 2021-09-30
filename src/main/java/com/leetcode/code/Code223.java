package com.leetcode.code;

public class Code223 {

    public static void main(String[] args) {

    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1 = (ax2-ax1) * (ay2-ay1);
        int s2 = (bx2-bx1) * (by2-by1);
//        右边最小值-左边最大值
        int x = Math.max(0, Math.min(ax2, bx2)-Math.max(ax1, bx1));
//        上边最小值-下边最大值
        int y = Math.max(0, Math.min(ay2, by2)-Math.max(ay1, by1));
        int s3 = x * y;
        return s1+s2-s3;
    }

}
