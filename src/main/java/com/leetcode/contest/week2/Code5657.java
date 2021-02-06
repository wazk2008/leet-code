package com.leetcode.contest.week2;

/**
 * @Description:
 * @ClassName: Code5657
 * @Author: ZK
 * @Date: 2021/2/6 22:32
 * @Version: 1.0
 */
public class Code5657 {

    public static void main(String[] args) {
        int[] nums = {14,83,63,42,15,87,61,37,30,95,99,100,45,30,5,2,29,65,15,71,12,17,61,81};
        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums) {
        int len = nums.length;

        int[] map = new int[101];
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            map[cur]++;
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (map[i] == 1) {
                sum += i;
            }
        }

        return sum;
    }

}
