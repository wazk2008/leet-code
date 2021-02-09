package com.leetcode.code;

/**
 * @ClassName Code665
 * @Author ZK
 * @Description
 * @Date 2021/2/7 12:33
 * @Version 1.0
 **/
public class Code665 {

    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len-1; i++) {
            int pre = nums[i-1];
            int cur = nums[i];
            int next = nums[i+1];
            if (pre > cur && cur > next) {
                return false;
            }
        }
        return true;
    }


}
