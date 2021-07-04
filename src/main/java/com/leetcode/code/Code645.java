package com.leetcode.code;

public class Code645 {

    public static void main(String[] args) {

    }

    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+1];
        for (int num : nums) {
            arr[num]++;
        }

        int[] res = new int[2];
        for (int i = 0; i <= len; i++) {
            if (arr[i] == 2) {
                res[0] = i;
                continue;
            }
            if (arr[i] == 0) {
                res[1] = i;
                continue;
            }
        }

        return res;
    }

}
