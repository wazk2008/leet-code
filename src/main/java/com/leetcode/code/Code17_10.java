package com.leetcode.code;

public class Code17_10 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {1,2,5,9,5,9,5,5,5};
        System.out.println(majorityElement2(nums));
    }

//    思路：摩尔选举
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int count = 1;

        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num == res) {
                count++;
            } else {
                if (--count == 0) {
                    res = nums[++i];
                    count++;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == res) {
                count++;
            }
        }

        return count*2 > len ? res : -1;
    }


    public static int majorityElement2(int[] nums) {
        int len = nums.length;
        int res = -1;
        int cnt = 0;

        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                cnt++;
            } else {
                cnt += res == num ? 1 : -1;
            }
        }
        cnt = 0;
        for (int num : nums) {
            if (num == res) {
                cnt++;
            }
        }

        return cnt > len/2 ? res : -1;
    }

}
