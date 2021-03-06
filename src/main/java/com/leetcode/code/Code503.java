package com.leetcode.code;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code503
 * @Author: ZK
 * @Date: 2021/3/6 18:09
 * @Version: 1.0
 */
public class Code503 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));

    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        Arrays.fill(res, -1);
//        定义一个栈，栈中存储的是数组的下标
        Stack<Integer> stack = new Stack<>();
//        需要考虑最后一个元素的下一个更大元素，所以循环到 2*len-1
        for (int i = 0; i < len*2-1; i++) {
//            如果超出len，则对len进行取模
            int index = i%len;
//            1.如果栈不为空
//            2.如果当前元素大于栈顶元素
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
//                设置栈顶元素为当前较大的这个元素
                res[stack.pop()] = nums[index];
            }
//            如果栈为空或者栈顶元素>=当前元素，入栈
            stack.push(index);
        }
        return res;
    }

}
