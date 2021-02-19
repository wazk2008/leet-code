package com.leetcode.code;

/**
 * @ClassName Code485
 * @Author ZK
 * @Description
 * @Date 2021/2/15 23:12
 * @Version 1.0
 **/
public class Code485 {

    public static void main(String[] args) {

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count = 0;
                continue;
            }
            count++;
            max = Math.max(max, count);
        }

        return max;
    }

}
