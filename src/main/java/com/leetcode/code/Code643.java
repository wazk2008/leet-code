package com.leetcode.code;

/**
 * @ClassName Code643
 * @Author ZK
 * @Description
 * @Date 2021/2/4 9:43
 * @Version 1.0
 **/
public class Code643 {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double res = findMaxAverage(nums, 4);
        System.out.println(res);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i <= len-k; i++) {
            sum = sum-nums[i-1] + nums[i+k-1];
            max = Math.max(sum, max);
        }

        return 1.0*max/k;
    }

}
