package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Code930 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int goal = 0;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0)+1);
            sum+=num;
            res += map.getOrDefault(sum-goal,0);
        }
        return res;
    }

}
