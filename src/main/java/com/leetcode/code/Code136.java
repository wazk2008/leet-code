package com.leetcode.code;

/**
 * @ClassName Code136
 * @Author ZK
 * @Description
 * @Date 2021/1/25 17:39
 * @Version 1.0
 **/
public class Code136 {
    public static void main(String[] args) {

    }
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
