package com.leetcode.code;

import java.util.Arrays;

public class Code453 {

    public static void main(String[] args) {

    }

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num-min;
        }
        return res;
    }

}
