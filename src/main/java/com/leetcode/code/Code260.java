package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Code260 {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-n));
        System.out.println(n & -n);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }

    public static int[] singleNumber1(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        // 防止溢出
        int newSum = (sum == Integer.MAX_VALUE ? sum : sum & (-sum));
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num&newSum) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }


    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }

        return res;
    }

}
