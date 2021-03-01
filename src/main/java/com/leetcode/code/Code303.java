package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code303
 * @Author: ZK
 * @Date: 2021/3/1 22:32
 * @Version: 1.0
 */
public class Code303 {

    private int[] sums;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Code303 code = new Code303(nums);
    }

    public Code303(int[] nums) {
        int len = nums.length;
        sums = new int[len+1];
        for (int i = 0; i < len; i++) {
            sums[i+1] = sums[i] + nums[i] ;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }

}
