package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code229 {

    public static void main(String[] args) {

    }

    public static List<Integer> majorityElement2(int[] nums) {
        int cand1 = 0;
        int cnt1 = 0;
        int cand2 = 0;
        int cnt2 = 0;

        for (int num : nums) {
            if (cand1 == num) {
                // 如果是第一个候选人
                cnt1++;
            } else if (cand2 == num) {
                // 如果是第二个候选人
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = num;
                cnt1++;
            } else if (cnt2 == 0) {
                cand2 = num;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for (int i : nums) {
            if (cand1 == i) {
                cnt1++;
            } else if (cand2 == i) {
                cnt2++;
            }
        }

        int len = nums.length/3;
        List<Integer> res = new ArrayList<>();
        if (cnt1 > len) {
            res.add(cand1);
        }
        if (cnt2 > len) {
            res.add(cand2);
        }
        return res;
    }


    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int len = nums.length;
        int n = len/3;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

}
