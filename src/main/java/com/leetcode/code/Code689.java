package com.leetcode.code;

public class Code689 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int[] res = maxSumOfThreeSubarrays(nums, 2);
        System.out.println(res[0] + "\t" + res[1] + "\t" + res[2]);
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        for (int i = 2*k; i < len; i++) {
            sum1 += nums[i-k*2];
            sum2 += nums[i-k];
            sum3 += nums[i];
            if (i >= 3*k-1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - (3*k-1);
                }
                if (maxSum1+sum2 > maxSum12) {
                    maxSum12 = maxSum1+sum2;
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - (2*k-1);
                }
                if (maxSum12+sum3 > maxTotal) {
                    maxTotal = maxSum12+sum3;
                    res[0] = maxSum12Idx1;
                    res[1] = maxSum12Idx2;
                    res[2] = i - (k-1);
                }
                sum1 -= nums[i-(3*k-1)];
                sum2 -= nums[i-(2*k-1)];
                sum3 -= nums[i-(k-1)];
            }
        }
        return res;
    }

}
