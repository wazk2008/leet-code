package com.leetcode.code;

import java.util.Arrays;

/**
 * @Description:
 * @ClassName: Code561
 * @Author: ZK
 * @Date: 2021/2/28 19:07
 * @Version: 1.0
 */
public class Code561 {

    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < len; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

}
