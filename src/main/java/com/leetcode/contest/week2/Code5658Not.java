package com.leetcode.contest.week2;

/**
 * @Description:
 * @ClassName: Code5658
 * @Author: ZK
 * @Date: 2021/2/6 22:58
 * @Version: 1.0
 */
public class Code5658Not {

    public static void main(String[] args) {
//        int[] nums = {1,-3,2,3,-4};
//        int[] nums = {2,-5,1,-4,3,-2};
        int[] nums = {-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9};
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
//        pre表示下一个元素的前边的最大子序和（绝对值）
        int pre = 0;
//        temp表示下一个元素的前边的最大子序和（原值）
        int temp = 0;
        int max = 0;

        for (int num : nums) {
//            pre = 一种是加上当前的元素，一种是只要当前自己
//            例：pre=-1, num=2 => 此时 pre=2
//            例：pre=1, num=2 => 此时 pre=3
            pre = Math.max( Math.abs(temp+num) , Math.abs(num));
            System.out.println(Math.abs(temp+num) +"\t"+ Math.abs(num));
            if (Math.abs(num) >= Math.abs(temp+num)) {
                temp = num;
            } else {
                temp = temp+num;
            }
            max = Math.max(pre, max);
        }
        return max;
    }

}
