package com.leetcode.code;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:
 * @ClassName: Code1843
 * @Author: ZK
 * @Date: 2021/2/21 00:17
 * @Version: 1.0
 */
public class Code1843 {

    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int min = nums[left];
        int max = nums[left];

        for (right = 0; right < len; right++) {
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);
            if (max-min <= limit) {
                res = Math.max(res, right-left+1);
                continue;
            } else {
//                移动左指针
                while(true) {
                    left++;
                    if (nums[left] == nums[left-1]) {
                        continue;
                    }
                    max = getMax(nums, left, right);
                    min = getMin(nums, left, right);
                    if (max-min <= limit) {
                        res = Math.max(res, right-left+1);
                        break;
                    }
                }
            }
        }

        return res;
    }

    public static int getMax(int[] nums, int start, int end){
        int max = nums[start];
        for (int i = start+1; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static int getMin(int[] nums, int start, int end){
        int min = nums[start];
        for (int i = start+1; i <= end; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }


}
