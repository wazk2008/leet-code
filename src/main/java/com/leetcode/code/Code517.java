package com.leetcode.code;

import java.util.Arrays;

public class Code517 {

    public static void main(String[] args) {

    }

    public static int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int n = machines.length;
        if (sum%n != 0) {
            return -1;
        }

        int avg = sum/n;
        int res = 0;
        // l: 应该给左边几件
        // r: 应该给右边几件
        int l,r=0;
        for (int i = 0; i < n; i++) {
            int num = machines[i];
            l = -r;
            r = num - avg - l;
            // 中间需要给两边，则需要步数相加
            // 如果是两边需要给中间，步数则不相加
            if (l>0 && r>0) {
                res = Math.max(res, Math.abs(l)+Math.abs(r));
            } else {
                res = Math.max(res, Math.max(Math.abs(l), Math.abs(r)));
            }
        }

        return res;
    }

}
