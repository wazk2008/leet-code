package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code448
 * @Author ZK
 * @Description
 * @Date 2021/2/13 21:45
 * @Version 1.0
 **/
public class Code448 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        if (len == 0) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num == len) {
                nums[0] = -1 * Math.abs(nums[0]);
            }
            if (num>0 && num < len) {
                nums[num] = -1 * Math.abs(nums[num]);
            }
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                res.add(i);
            }
        }
        if (nums[0] > 0) {
            res.add(len);
        }

        return res;
    }

}
