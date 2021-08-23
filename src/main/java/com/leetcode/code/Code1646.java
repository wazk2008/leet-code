package com.leetcode.code;

public class Code1646 {

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }

    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int max = nums[1];
        for (int i = 2; i < n+1; i++) {
            if ((i & 1) == 0) {
                nums[i] = nums[i/2];
            } else {
                nums[i] = nums[i/2] + nums[i/2+1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }

}
