package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @ClassName: Code377
 * @Author: ZK
 * @Date: 2021/4/24 21:29
 * @Version: 1.0
 */
public class Code377 {

    public static void main(String[] args) {

    }

//    key : target
//    val : total number of target
    static Map<Integer, Integer> map = new HashMap<>();

    public static int combinationSum4(int[] nums, int target) {
        return backtrack(nums, target);
    }

    private static int backtrack(int[] nums, int target){
        if (target == 0) {
            return 1;
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += backtrack(nums, target - nums[i]);
            }
        }
        map.put(target, res);
        return res;
    }

}
