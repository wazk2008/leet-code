package com.leetcode.code;

/**
 * @ClassName Code41
 * @Author ZK
 * @Description
 * @Date 2021/1/26 16:04
 * @Version 1.0
 **/
public class Code41 {

    public static void main(String[] args) {
        int[] nums = {98,93,95,10,91,4,90,88,56,84,65,62,83,80,78,60,73,77,76,29,63,12,57,17,69,68,50,11,31,33,8,42,38,7,0,37,48,26,20,44,46,43,52,51,47,18,49,58,2,39,30,81,22,55,36,40,15,27,21,32,64,41,53,19,28,24,9,25,3,59,66,82,61,70,23,34,71,54,74,-1,1,45,14,79,5,35,13,72,75,85,87,6,16,86,67,89,94,92,96,97};
//        int[] nums = {2,0,1};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int res = -1;

//        1.先将所有的<=0的数据改成len+1，保证其不在正常区间内
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len+1;
            }
        }

//        循环数组
        for (int i = 0; i < len; i++) {
//            做的标记为将正数修改为负数，此处取出原来的正数
            int cur = Math.abs(nums[i]);
//            如果当前数字在正常区间内
            if (cur <= len) {
//                对应下标的数字做标记（记成负数），表示下标数已经存在
                int newIndex = cur-1;
                nums[newIndex] = - Math.abs(nums[newIndex]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                res = i+1;
                return res;
            }
        }
        return len+1;
    }

}
