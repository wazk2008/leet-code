package com.leetcode.code;

/**
 * @ClassName Code53
 * @Author ZK
 * @Description
 * @Date 2021/2/1 15:17
 * @Version 1.0
 **/
public class Code53 {

    public static void main(String[] args) {
        int[] nums = {-1,0,-2};
        System.out.println(maxSubArray0(nums));
        System.out.println(maxSubArray(nums));
    }


    /**
     * 暴力
     * @param nums
     * @return
     */
    public static int maxSubArray0(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
            sum = 0;
        }
        return max;
    }


    /**
     * 动态规划，滚动数组
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

}
