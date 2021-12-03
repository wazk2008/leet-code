package com.leetcode.code;

import java.util.PriorityQueue;
import java.util.Queue;

public class Code1005 {

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        int k = 1;
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    // 方法一  优先队列
    // 方法二  排序，从左到右遍历，判断k，遇到负数变成绝对值，遇到0停止，遇到整数判断(k-负数数量)的奇偶性
    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 若负数数量 大于 等于k，则将最小的k个负数变为正数。
        // 若负数数量小于k，则将所有负数变为正数，之后根据 k 减去 负数的数量 的剩余值的奇偶性，进一步判断。
            // 若剩余值为偶数，则不用管。
            // 若剩余值为奇数，减去绝对值最小的值。

        Queue<Integer> queue = new PriorityQueue<>();
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (num < 0) {
                cnt++;
            }
            queue.offer(num);
        }

        // 负数的数量>=k，处理k个负数
        if (cnt >= k) {
            while (k-- > 0) {
                Integer temp = queue.poll();
                queue.offer(-temp);
                sum = sum - temp + (-temp);
            }
        } else {
            // 负数的数量<k，处理所有的(cnt个)负数
            while (queue.peek() < 0) {
                Integer temp = queue.poll();
                queue.offer(-temp);
                sum = sum - temp + (-temp);
            }
            // 判断k-cnt的奇偶性
            // 奇数
            if (((k-cnt)&1) == 1) {
                Integer temp = queue.poll();
                sum = sum - temp + (-temp);
            }
        }
        return sum;
    }

}
