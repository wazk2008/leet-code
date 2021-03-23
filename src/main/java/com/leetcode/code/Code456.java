package com.leetcode.code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code456
 * @Author: ZK
 * @Date: 2021/3/24 00:55
 * @Version: 1.0
 */
public class Code456 {

    public static void main(String[] args) {
        int[] nums = {1,11,10,4,3,2};
        System.out.println(find132pattern2(nums));
    }

//    用栈，9ms
    public static boolean find132pattern(int[] nums) {
        int len = nums.length;
//        定义栈
        Deque<Integer> stack = new LinkedList<>();
//        栈中存放最后一个元素，相当于存了mid
        stack.push(nums[len-1]);
//        默认情况下right为最小值
        int right = Integer.MIN_VALUE;

        for (int i = len-2; i >= 0; i--) {
//            如果当前数字小于right，则return true
            if (nums[i] < right) {
                return true;
            }
//            如果当前元素比栈顶元素大，则将right更新为栈顶元素
//            以此来保证right一定是比mid小的最大元素
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                right = stack.pop();
            }
//            如果当前元素大于right，则将当前元素入栈
//            下一个元素如果小于right，则return true
//            下一个元素如果大于栈顶元素，则更新right为栈顶元素，则right变大
            if (nums[i] > right) {
                stack.push(nums[i]);
            }
        }

        return false;
    }

//    用数组代替栈，2ms
    public static boolean find132pattern2(int[] nums) {
        int len = nums.length;
//        定义栈
        int[] stack = new int[len];
        int index = 0;
//        栈中存放最后一个元素，相当于存了mid
        stack[index++] = nums[len-1];
//        默认情况下right为最小值
        int right = Integer.MIN_VALUE;

        for (int i = len-2; i >= 0; i--) {
//            如果当前数字小于right，则return true
            if (nums[i] < right) {
                return true;
            }
//            如果当前元素比栈顶元素大，则将right更新为栈顶元素
//            以此来保证right一定是比mid小的最大元素
            while(index>0 && nums[i]>stack[index-1]){
                right = stack[--index];
            }
//            如果当前元素大于right，则将当前元素入栈
//            下一个元素如果小于right，则return true
//            下一个元素如果大于栈顶元素，则更新right为栈顶元素，则right变大
            if (nums[i] > right) {
                stack[index++] = nums[i];
            }
        }

        return false;
    }


}
