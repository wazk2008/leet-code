package com.leetcode.code;

/**
 * @ClassName Code724
 * @Author ZK
 * @Description
 * @Date 2021/1/28 14:23
 * @Version 1.0
 **/
public class Code724 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,0};
        int index = pivotIndex(nums);
        System.out.println(index);
    }

//    前缀和
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum1 = 0;
        for (int i = 0; i < len; i++) {
           sum1 += nums[i];
        }

        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum2 += nums[i];
//            此时i的位置便是中心索引位置，左右两边都累加了中间值
            if (sum2 == sum1) {
                return i;
            }
            sum1 -= nums[i];
        }
        return -1;
    }

//    之前采用双指针法，对于有负数的情况失效。故放弃
    public static int pivotIndex0(int[] nums) {
        int res = -1;

        int left = 0;
        int right = nums.length-1;
        int leftSum = nums[left];
        int rightSum = nums[right];

        while(left < right){

            if (leftSum > rightSum) {
                right--;
                rightSum += nums[right];
            } else if (leftSum < rightSum) {
                left++;
                leftSum += nums[left];
            } else {
                if (nums[left+1] < nums[right-1]){
                    left++;
                    leftSum += nums[left];
                } else if (nums[left+1] > nums[right-1]){
                    right--;
                    rightSum += nums[right];
                } else {
                    left++;
                    leftSum += nums[left];
                    right--;
                    rightSum += nums[right];
                }
            }

        }

        if (leftSum == rightSum) {
            res = left == right ? left : -1;
        }

        return res;
    }

}
