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
        int count = 0;
        for (int i = 1; i < len; i++) {
            int pre = nums[i-1];
            int cur = nums[i];

            if (pre > cur) {
                if (i==1 || nums[i] >= nums[i-2]){
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }


}
