package com.leetcode.code;

import java.util.Arrays;

public class Code611 {

    public static void main(String[] args) {
        int[] num = {0,0,0,7};
        System.out.println(triangleNumber(num));


    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len-2; i++) {
            int k = i+1;
            for (int j = i+1; j < len-1; j++) {
                while (k+1 < len && nums[k+1] < nums[i]+nums[j]) {
                    k++;
                }
                res += Math.max(k-j, 0);
            }
        }

        return res;
    }

}
